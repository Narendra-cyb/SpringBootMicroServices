# SpringBootMicroServices
Before going to MicroService it's better to have idea about RestTemplate 
To Use RestTemplate **Example**
We can use RestTemplate in two way <br>
- **GetForEntity / PostForEntity**
- **exchange() method** <br>
### GetForEntity
* We need RestTemplate Bean to work
We can take **@Bean or RestTemplate tempalte = new RestTemplate();** <br>
But if we are taking @Bean it can work across all project.

```java
@SpringBootApplication
public class SringbootProjectClientApplication {
	
	@Bean
	public RestTemplate creatTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SringbootProjectClientApplication.class, args);
	}

}
```
``` java
public class ClientRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.url}")
	private String url;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(url);
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class,Map.of("id",1,"msg","Hey How are You"));
//		System.out.println("response body "+response.getBody());
//		System.out.println("response header "+response.getHeaders());
//		System.out.println("response body "+response.getStatusCode());
//		System.out.println("response body "+response.getStatusCodeValue());
//		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonBody = "{\"id\":1001,\"name\":\"Narendra\",\"add\":\"Regada\"}";
		HttpEntity<String> request = new HttpEntity<String>(jsonBody,headers);
		//send post using Response post entity
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		//process object
		System.out.println("body "+response.getBody());
		System.out.println("headers "+response.getHeaders());
		System.out.println("status code "+response.getStatusCode());
		//send post using Response object Entity
		String response1 = restTemplate.postForObject(url, request, String.class);
		System.out.println("response using post for object"+response1);

	}
}
```

### exchange()
Instead of using getforEntity(),postforEntity(), put(), delete() as separate methods to generate different modes of requests ... we can use single exchange(...) for all operations.<br>

~~~
public <T> ResponseEntity<T> exchange(String url,
 HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType,Object... uriVariables)  throws RestClientException  
Parameters:
url - the URL
method - the HTTP method (GET, POST, etc)
requestEntity - the entity (headers and/or body) to write to the request may be null)
responseType - the type to convert the response to, or Void.class for no body
uriVariables - the variables to expand in the template
~~~
``` java
public class GetRunnerTest implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	@Value("${service.url}")
	private String url;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println("body "+responseEntity.getBody());
		System.out.println("headers "+responseEntity.getHeaders());
		System.out.println("");
	}
}
```
- **Object Mapper**
  - if web service method/operations return type is other than  ResponseEntity<String> then we get JSON response as text content.. by default..     this JSON text content can be used directly or can be converted to java object using JACKSON API
  - The  ObjectMapper class of Jackson api gives methods for Seriliziation and Deserialization
    - mapper.readValue() :: JSON text to Object (Deserialization)
    - mapper.writeValue() :: Object to Json Text (Serialization)
``` java
public class ObjectMapperListRunner implements CommandLineRunner{

	
	@Value("${service.mapUrl2}")
	private String url;
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
		ObjectMapper object = new ObjectMapper();
		List<Actor> value = object.readValue(response.getBody(), new TypeReference<List<Actor>>() {});
		value.forEach(System.out::println);
		
	}
	
	/*
	@Value("${service.mapUrl}")
	private String url;

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class);
		
		System.out.println("body: "+entity.getBody());
		System.out.println("header: "+entity.getHeaders());
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(entity.getBody(), Actor.class);
		System.out.println("json to object convertion data :: "+actor);
	}
	*/
}
```
-  But the return object Like above code Actor.class it should be present in client side also ,common sense it'll store where ? so need to create it also.<br>
*Service Api Method* 
``` java
// Returning List<Actor> as ResponseEntity
	@GetMapping("/request2")
	public ResponseEntity<List<Actor>> getAllActorList() {
		List<Actor> actors = List.of(new Actor("Vijay Setupathi", "Vikram"), new Actor("Ayushman", "Andhadhun"));
		return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
	}
```
*Another Example Post Using exchange()*
```java
@Component
public class PostRunnerTest implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	@Value("${service.postUrl}") //in application.properties service.postUrl = http://localhost:8080/service/register
	private String url;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String body = "{\"id\":200,\"name\":\"Naren\",\"add\":\"bbsr\"}";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(body,header);
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getStatusCode());
	}
}

```
*Service Api Method* 
```java
@PostMapping("/register")
public ResponseEntity<String> postuser(@RequestBody User user) {
  return new ResponseEntity<String>("post user details are: " + user, HttpStatus.ACCEPTED);
}
```
