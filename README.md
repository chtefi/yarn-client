The fatjar contains everything needed. It's useable outside of a hadoop server.
Note that the address of the targetted server is hardcoded inside the program, for the sake of simplificity.

```
$ mvn package
$ java -jar target/yarn-client.jar
```

But if we want to run the program directly on a hadoop server, we can just add the hadoop jars of the system to the classpath.
`original-yarn-client-1.0-SNAPSHOT.jar` is not a fatjar, it just contains the Main class compiled.
```
$ java -cp `hadoop classpath`:original-yarn-client-1.0-SNAPSHOT.jar com.company.Main
```