# Spring Cloud OpenFeign

In our Spring Projects, we will look at using Feign Client, where we can easily establish and manage communication between our services.

We can ensure communication between our services using RestTemplate, which we can call the classical method. Using the communication method with RestTemplate, we make our methods dependent by using the relevant API request within our methods.

By using OpenFeign, we manage service communication through interface templates and enable us to use it in a more readable and configurational manner.

In our application, communication will occur between the following services with OpenFeign.
### AuthService
### UserProfileService

After the registered person completes their authentication, the UserProfileService will be notified and person will be added to the user database.
