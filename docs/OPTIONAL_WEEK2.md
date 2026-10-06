# Optional Tutorial 2 practice

These are deliberately separate from the required final classes and diagrams.

## Static customer count

Add inside Customer:

```java
private static int customerCount = 0;
public static int getCustomerCount() { return customerCount; }
```

Add `customerCount++;` inside BOTH existing constructors. Do not call one constructor from the other
while incrementing in both, or a single object could be counted twice.
The value counts Customer objects constructed in this running JVM, not unique people or saved records.
Static members belong to the class; underline them in a conventional UML drawing.
A static getter is not a per-customer JSON property; use Customer.getCustomerCount() in Java to inspect it.

## Plain array tags

Add `private String[] tags;`, a public `String[] getTags()` getter,
and `public void setTags(String[] tags) { this.tags = tags; }`.
In CustomerController create the customer in a local variable, call:

```java
customer.setTags(new String[]{"student", "regular"});
return customer;
```

Expected extra JSON property: `"tags": ["student", "regular"]`.
Add the array field/getter/setter to your UML if you implement this extension.

## Move the URL prefix

In ProductController remove `@RequestMapping("/products")` and its unused import.
Change the method annotation to `@GetMapping("/products/{id}")`.
Restart and verify /products/1 still works. The original class-level prefix and method-level suffix
combined to make the same full URL.
