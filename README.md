# ubirch Utils

## crypto

### Scala Dependency

#### `config`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "config" % "0.1"
    )


#### `crypto`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
	  "RoundEights" at "http://maven.spikemark.net/roundeights"
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "crypto" % "0.3"
    )

##### Release History

###### Version 0.3 (2016-10-28)

migrated crypto code from old ubirch project to this util module.


#### `date`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "date" % "0.1"
    )


#### `elasticsearch-client-binary`

A client for Elasticsearch 2.4 using the binary protocol through
[TransportClient](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html).

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "elasticsearch-client-binary" % "0.2.4"
    )

##### Release History

###### Version 0.2.5 (2016-11-01)

update dependency com.ubirch.util:json from version 0.2 to 0.3.

###### Version 0.2.4 (2016-10-31)

update dependency com.ubirch.util:json from version 0.1 to 0.2.

###### Version 0.2.3 (2016-10-27)

added `SortUtil`.

###### Version 0.2.2 (2016-10-26)

added sort parameter to `ElasticsearchStorage.getDocs`.

###### Version 0.2.1 (2016-10-26)

additional check: `from` and `size` parameters in `ElasticsearchStorage.getDocs` may not be negative. 

###### Version 0.2 (2016-10-25)

docId in `ElasticsearchStorage.storeDoc` is now optional. 

###### Version 0.1

first release


#### `json`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "json" % "0.3"
    )

##### Release History

###### Version 0.3 (2016-11-01)

* updated json4s dependencies to verion 3.4.2

###### Version 0.2 (2016-10-28)

* deleted method Json4sUtil.string2Any
* added method Json4sUtil.inputstream2jvalue


#### `json-auto-convert`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.bintrayRepo("hseeberger", "maven")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "json-auto-convert" % "0.3"
    )

###### Version 0.3 (2016-11-01)

* update json4s dependency from version 3.4.0 to 3.4.2


#### `rest-akka-http`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "rest-akka-http" % "0.1" // for Akka 2.4.9-RC2
      "com.ubirch.util" %% "rest-akka-http" % "0.2" // for Akka 2.4.10
      "com.ubirch.util" %% "rest-akka-http" % "0.3" // for Akka 2.4.11
    )


#### `uuid`

    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases")
    )
    libraryDependencies ++= Seq(
      "com.ubirch.util" %% "uuid" % "0.1"
    )
