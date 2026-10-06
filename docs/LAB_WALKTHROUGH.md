# Tutorial 1 and Tutorial 2 walkthrough

## Week 1

1. Open/import this Maven project and run ProductsApiApplication (see README).
2. Test GET /hello and /status. Both return HTTP 200.
3. Swagger UI is configured in pom.xml. Test the same endpoints at /swagger-ui.html.
4. Person.java includes the added private email field and getEmail(); its constructors and setters are present.
5. GET /goodbye returns exactly `Goodbye from Spring Boot!`.
6. Optional stretch tasks are included: /status contains LocalDate.now() and InfoController exposes /info.
7. Review changes, commit/push through your own GitHub account, then verify the repository in a browser.

## Week 2 Activity 1 — public fields and an object response

The ZIP contains the final encapsulated Product. To reproduce the first experiment, temporarily replace ONLY
Product.java with this version, retaining the package:

```java
package uk.ac.westminster.products_api;

public class Product {
    public Long id;
    public String name;
    public double price;

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
```

Restart. Test /products/1. Expected:

```json
{"id":1,"name":"Laptop","price":999.99}
```

ProductController returns a Product object. Spring's HTTP JSON converter uses Jackson to serialize it.
`@RequestMapping("/products")` supplies the class-level URL prefix.
`@GetMapping("/{id}")` supplies the method-level part. `@PathVariable` reads the ID from the URL.
This endpoint returns a new sample object for any valid Long ID; there is no stored list in this tutorial.

## Activity 2 — encapsulation

Change ONLY the three fields from public to private. Predict the response, restart and test /products/1.
The supplied lab-only configuration allows the expected `{}` response with HTTP 200.
Without `spring.jackson.serialization.fail-on-empty-beans=false`, Jackson's empty-bean handling may
instead return HTTP 500; that does not mean the private-fields experiment failed.

Restore the final Product.java: private fields, public no-argument constructor,
public three-argument constructor and getId/getName/getPrice. Restart. All three JSON properties return.

Private fields prevent other Java classes from accessing the fields directly. Public getters let callers read them.
`this.name = name` assigns the parameter on the right to this object's field on the left.
The full constructor supplies initial values. The no-argument constructor supplies no values:
Long/String start as null and primitive double starts as 0.0.
The no-argument constructor is included for the next tutorial's JSON-input pattern; it is not required for GET serialization.
JSON input also needs a way to populate properties (for example setters), or an explicitly configured creator.

## Activity 3 — one missing getter

1. Temporarily comment out getName() only in Product.java.
2. Predict the response. Restart and execute /products/1.
3. Expected: `{"id":1,"price":999.99}`; HTTP 200. The private name value still exists in the object,
   but it is no longer exposed as a serializable property in this class's default getter-based configuration.
4. Explanation: getId/getPrice are still discoverable, while getName has been removed.
5. Written reflection: "I would compare the JSON response's properties with the expected API contract;
   HTTP 200 alone does not prove that all expected data is present."
6. Restore getName(), restart and confirm that name returns.

Commit a real note of your observation (for example in docs/my-observations.md). Restoring a getter produces
no final source diff, so an observation note records what you actually tested without inventing a source change.

## Activity 4 — Product UML

Open docs/uml/Product.svg. The diagram has class name, attributes, and operations in three compartments.
`-` means private; `+` means public. Attributes use `name : Type`; getters include return types.
Constructors have no return type. Both constructors and all three getters are included.
The source files are provided in PlantUML and Mermaid formats for editing.

## Activity 5 — Customer has an Address

Address has private street/city/postcode and their getters.
Customer has private id/name/email/address; address has type Address, not String.
CustomerController creates an Address, then passes it into the Customer constructor.
Restart and test /customers/1:

```json
{
  "id": 1,
  "name": "Ada Lovelace",
  "email": "ada@example.com",
  "address": {
    "street": "115 New Cavendish Street",
    "city": "London",
    "postcode": "W1W 6UW"
  }
}
```

Temporarily comment out Customer.getAddress(), restart and test again.
The entire address property disappears. Restore getAddress(), restart and confirm it returns.
This is a has-an association, not inheritance.

## Activity 6 — Customer/Address UML

Open docs/uml/CustomerAddress.svg. Customer includes `- address : Address`.
A solid line with an open arrowhead points from Customer to Address.
Both class boxes contain all fields, both constructors and all getters.

## Account actions you must complete

- Use your own Tutorial 1 GitHub repository. Preserve its existing Git history.
- Commit and push incremental work and observations; do not backdate or fabricate lab commits.
- Suggested messages after the corresponding work:
  - Tutorial 2: Product class and /products endpoint added
  - Tutorial 2: Product encapsulated with private fields and getters
  - Tutorial 2: recorded getter-removal observations
  - Tutorial 2: Product UML class diagram added
  - Tutorial 2: Customer and Address classes with association
  - Tutorial 2: encapsulation and UML for Product, Customer and Address
- Check the Java files and both diagrams are visible on GitHub.
- Paste your repository URL into the Blackboard Tutorial 2 submission.
- On a shared university PC, sign out of GitHub and remove your GitHub account from IntelliJ,
  close IntelliJ and log off.

These account actions and your personal experiment observations cannot be completed by a reference ZIP.
