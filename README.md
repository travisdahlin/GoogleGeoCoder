# GoogleGeoCoder

Code will query the Google Maps API and parse longitude/latitude for the given address.
Enter the street address, city, state in the location var and execute.

```bash
$ groovy GoogleGeoCoder.groovy
```

# Compile .groovy to jar

- create the .class file

```bash
$ groovyc filename.groovy
```

- create a manifest file
  - note: new line at at eof is required
  - note: copy the groovy jar file to the jar directory.

```bash
Main-class: ClassName
Class-path: jar\groovy-all-2.4.7.jar
```

- create jar file

```bash
$ jar cvfm fileName.jar manifest.txt *.class
$ java -jar filename.jar
```
