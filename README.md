# Prerequisites
* Java 11+
* Gradle

# Tests
Run:

* MacOS/Linux
    ```
    ./gradlew test -i
    ```
* Windows
    ```
    gradlew.bat test -i
    ```

# Notes

* It's not a production ready code. It's just an idea
* To get to production we need:
  * Implement a controller
  * Apply a framework to implement routine capabilities (e.g. Spring Boot, etc.)
  * Choose a real database which we want to use (e.g. MySQL, PostgreSQL, etc.)
  * Implement a repository (e.g. **MySqlCoffeeShopRepository**) with real query to a Database (see the **Performance** note)
* Performance: in order to query the closest coffee shops from a Database in an efficient way we should use optimizations
  (e.g. Bounding box, etc. See http://mysql.rjweb.org/doc.php/find_nearest_in_mysql) to avoid scan of all records of coffee shops
* API:
  * Request:
    ```
    {
     "latitude": 53.85034014462827, 
     "longitude": 27.4712052781082,
     "limit": 5,
     "distance": 10000.0
    }
    ```
  * Response:
    ```
    [
     {
      "id": 1,
      "name": "Shop 1",
      "latitude": 53.85034014462827, 
      "longitude": 27.4712052781082,
      "distance": 5000.0
     }
    ]
    ```