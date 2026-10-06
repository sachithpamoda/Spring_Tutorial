# Product

```mermaid
classDiagram
    class Product {
        -Long id
        -String name
        -double price
        +Product()
        +Product(id Long, name String, price double)
        +getId() Long
        +getName() String
        +getPrice() double
    }
```
