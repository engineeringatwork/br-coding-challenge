## Application Requirements

1. You have information on videos for a show, a list of images associated with a show, and a list of video ads associated with a show all considered "assets".
2. Each asset has an ID, a name, a type indicator, a URL, and an expiration date.
3. Videos have a field that indicates if it is a movie, a full episode or a clip.
4. Image assets can be represented by a base asset.
5. Ad assets include a field for a product description.
6. Containers describe a collection of assets.
7. Containers can be considered a "show" with information that includes an ID, name, description, and assets.

## Application Output Expectations

1. Create a program that generates at least one container with many assets (at least one of each type) with all properties set.
2. The program should visit each asset and print information about that asset specific to the type of asset 

## Application Requirements
1. Java 1.8
2. Gradle 4.0
3. Favorite IDE (Spring Tool Suite

## High Level Design Approach

Application was developed as micro service application that can be deployed out on cloud provider of your choice. The application is self contained as a fat jar with embedded Tomcat 8.5.31 web server already included within it as well as Swagger API documentation provided as well. Application is leveraging an embedded in-memory H2 database that stores the database schema.

## API Endpoints



