### Learning Concurrent Programming in Scala
My solutions to the exercises from the great book [Learning Concurrent Programming in Scala](http://axel22.github.io/publications/learning-concurrent-programming-in-scala/)

1. [Introduction](src/main/scala/org/learningconcurrency/Chapter01.scala) => [tests](src/test/scala/org/learningconcurrency/Chapter01Spec.scala)
2. [Concurrency on the JVM and the Java Memory Model](src/main/scala/org/learningconcurrency/Chapter02.scala) => [tests](src/test/scala/org/learningconcurrency/Chapter02Spec.scala)
3. Traditional Building Blocks of Concurrency
4. Asynchronous Programming with Futures
5. Data-Parallel Collections
6. Concurrent Programming with Reactive Extensions
7. Software Transactional Memory
8. Actors
9. Concurrency in Practice

Almost all solutions are covered with corresponding tests.
You can build and run tests and see the coverage by using the following command:

```bash
activator clean coverage test coverageReport
```
