# Completed Week 1 and Week 2 — products-api

5COSC019W Object Oriented Programming, University of Westminster / IIT.
A runnable reference solution to the required coding and UML activities in both tutorial guides.

## Open in IntelliJ IDEA (Windows)

1. Extract the ZIP first (right-click > Extract All). Do not open files inside the ZIP preview.
2. IntelliJ > File > Open > choose the `products-api` folder that contains **pom.xml**.
   If opening `pom.xml` directly, choose **Open as Project**. Trust the project.
3. File > Project Structure > Project > set **Project SDK: JDK 17**.
   If absent, choose Add SDK > Download JDK > version 17.
4. Settings > Build, Execution, Deployment > Build Tools > Maven:
   use **Bundled Maven** or **Maven Wrapper**. For Maven > Importing and Maven > Runner,
   choose Project JDK / JDK 17. No system Maven environment variable is needed.
5. Click Reload All Maven Projects in the Maven tool window. Wait for dependencies to download.
   The first import requires internet access.
6. Open `src/main/java/uk/ac/westminster/products_api/ProductsApiApplication.java`.
   Click the green Run arrow beside `main`.
7. Wait for `Started ProductsApiApplication` in the console.
8. Open http://localhost:8080/swagger-ui.html in your browser.

If port 8080 is occupied, stop your previously running API using IntelliJ's red Stop button.
If Java files are missing, expand `src > main > java > uk.ac.westminster.products_api`.
If Maven is not recognised, right-click `pom.xml` > Add as Maven Project / Maven > Reload Project.

## Terminal alternative

Windows PowerShell (from the products-api folder):

```powershell
.\mvnw.cmd spring-boot:run
```

macOS/Linux:

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Run the included checks: `.\mvnw.cmd test` on Windows or `./mvnw test` on Linux/macOS.
The wrapper downloads Maven automatically on its first use. JAVA_HOME must point to a JDK 17 installation.

## Finished endpoints

| Method | URL | Expected result |
| --- | --- | --- |
| GET | /hello | Hello from Spring Boot! |
| GET | /goodbye | Goodbye from Spring Boot! |
| GET | /status | API is running — Tutorial 1 — followed by today's date |
| GET | /info | Application description (Week 1 stretch task) |
| GET | /products/1 | Product JSON: id 1, name Laptop, price 999.99 |
| GET | /customers/1 | Ada Lovelace with a nested London address |

In Swagger: expand an endpoint > Try it out > enter ID if requested > Execute.

`/products/{id}` and `/customers/{id}` intentionally return fixed tutorial samples with your supplied ID.
They do not look up a stored record. This is the Week 1/2 reference project, with no database or service-layer CRUD.

## Classes and diagrams

All nine Java source files are under `src/main/java/uk/ac/westminster/products_api`.
The package follows your existing `products_api` spelling instead of the PDF's `productsapi`.
`Product` uses primitive `double`, matching the tutorial and its UML; your earlier CRUD project used `Double`.
`Person` has name/email, constructors, getters and setters. Week 2 classes follow the guide's getter-only design.

- `docs/uml/Product.svg`: finished three-compartment Product diagram.
- `docs/uml/CustomerAddress.svg`: finished Customer-to-Address association diagram.
- PNG copies of both diagrams are included for viewing or printing.
- Corresponding `.puml` files keep the exact UML source editable.
- Corresponding `.md` files render Mermaid diagrams directly on GitHub.
- `docs/LAB_WALKTHROUGH.md`: all activities, getter experiments, explanations, and Git/submission checklist.
- `docs/OPTIONAL_WEEK2.md`: optional Week 2 stretch exercises.

The getters are restored in the delivered project. The public-field and missing-getter stages are experiments
for you to run using the walkthrough; they are not left as the final code.

## Dependency choice

Java 17, Spring Boot 3.5.6 and springdoc-openapi 2.8.13 are used together.
The Week 1 PDF's springdoc 3.1.1 belongs to the Spring Boot 4 line, so it is not mixed with Boot 3 here.
Compatibility reference: https://springdoc.org/v2/ and https://springdoc.org/faq.html.

## Git and submission

This ZIP contains no fabricated Git history. If you have a Tutorial 1 repository, copy the source and docs into
that repository (keep its `.git` folder), review the changes and make real commits as you work through the activities.
GitHub push, Blackboard submission and shared-PC sign-out must be done through your own accounts.
See the walkthrough for the checklist and suggested commit messages.
