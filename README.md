# Micro Service
Micro service is Extension Restful web service model
in this architecture every service/module will be developed as separate project/App
It is decoupled Architecture of a single project because multiple services/ modules will be developed as multiple projects and they will be registered/integrated in a common place.<br>
*MicroServices App = Restful app++*
- Every MicroService will be developed as Restful App and will be place in common registry/server
to make it available for other micro services or client apps.
- Horizontal scaling instead of vertical scaling
- Some terms of Micro Service
  - **Service Instance**
    -  A running Application inside the server giving services to Clients is called Service Instance.
    -  Each copy of app(jar or war) that is deployed in server succesfully to render services for clients is Service Instance.
  -  **Load Count**
        - The no. of requests that are currently under processing by service instance is called Load Count.
        - If the App1 instance is currently processing 10 requests than the Load count is 10.
  -  **Load Factor**
        - Load factot = Load/Max Load
        - if App instance server max load is 150 and that app instance is processing only 100 requests currently than 100/150 is the Load factor
      Which is (0.666)  Load factor is always *(>=0 to <=1)*
- **Architecture**
    -  **R & D servers:** (Register and Discovery) eg:- Netflix Eureka Server
    - **Config Server :** Common properties store and a server eg:- Config Server
    -  **Circuit Breaker :** if any exception raised in the execution of one microservice than it informed to admin Ui with support of Circuit Breaker.
    -  **Load Balancer Client :** eg: Feign Client,  LoaaBalancer
    -  **Integrations :** Mail, Caching, Batch Processing
    -  **Api Gateway :** Common entry and exit point , to use all the multiple microservices<br>
[Reference Note](https://github.com/Narendra-cyb/SpringBootMicroServices/upload/main/Image)
