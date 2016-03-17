The fatjar contains everything needed. It's useable outside of a hadoop server :
```
$ mvn package
$ java -jar target/yarn-client.jar
```

But on a hadoop server, you can just add the hadoop jars of the system to the classpath :
(`original-yarn-client-1.0-SNAPSHOT.jar` is not a fatjar)
```
$ java -cp `hadoop classpath`:original-yarn-client-1.0-SNAPSHOT.jar com.company.Main
```