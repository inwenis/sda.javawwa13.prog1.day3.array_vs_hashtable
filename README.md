# Data structures - Array vs HashMap

The purpose of this repo is to show the importance of using correct data structures.


## Array

Use `PatientRegistryUsingArray` to see how long it takes to loop up 100 patients in a `Array`

A single client needs ~8s to lookup 100 patients in an array of 10000000.

10 clients running concurrently need ~80s each to lookup 100 patients in an array of 10000000.

## HashMap

Use `PatientRegistryUsingHashMap` to see how long it takes to loop up 100 patients in a `HashMap`.

A single client needs 0.0009s (less than 1/10th of a ms) to lookup 100 patients in an array of 10000000.

10 clients running concurrently need 0.01s (~10ms) each to lookup 100 patients in an array of 10000000.

## Exercise (this is your TODO)

Implement `OurOwnHashMap` and test what is the performance of your own hash map compared to a table and a HashMap from `java.util`.

Here a piece of code you can use to write you `hash()` function:

```
int hash = 7;
for (int i = 0; i < strlen; i++) {
    hash = hash*31 + charAt(i);
}
```

## Conslusion

Using the correct data structure is important.
