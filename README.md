# Trabajo Práctico Desarrollo Seguro

## Configuración del postman 

* Importar `Android Desarrollo Seguro.postman_collection.json` en **POSTMAN** para tener los request configurados.

## Como subir a Heroku

* Se requerirá tener instalado Heroku Cli. (https://devcenter.heroku.com/articles/heroku-cli)
* Se requerirá tener Maven instalado.

## Como levantar app localmente

* Ejecutar mvn clean package: descargará dependencias.
* Ejecutar **/airline-development-security/src/main/java/Main.java**: se encargará de levantar routers y modules.


-----------

##### Agregar al POM.xml
    
        <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>2.3.2</version>
                        <configuration>
                            <source>1.8</source>
                            <target>1.8</target>
                        </configuration>
                    </plugin>
                    <plugin>
                        <artifactId>maven-assembly-plugin</artifactId>
                        <executions>
                            <execution>
                                <phase>package</phase>
                                <goals>
                                    <goal>single</goal>
                                </goals>
                            </execution>
                        </executions>
                        <configuration>
                            <descriptorRefs>
                                <!-- This tells Maven to include all dependencies -->
                                <descriptorRef>jar-with-dependencies</descriptorRef>
                            </descriptorRefs>
                            <archive>
                                <manifest>
                                    <mainClass>Main</mainClass>
                                </manifest>
                            </archive>
                        </configuration>
                    </plugin>
        
                    <plugin>
                        <groupId>com.heroku.sdk</groupId>
                        <artifactId>heroku-maven-plugin</artifactId>
                        <version>0.4.4</version>
                        <configuration>
                            <jdkVersion>1.8</jdkVersion>
                            <appName>${artifactId}</appName>
                            <processTypes>
                                <web>java -jar ./target/${artifactId}-${version}-jar-with-dependencies.jar</web>
                            </processTypes>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
            
            
#### Crear App:

    heroku create [artifact-id]

#### Desplegar:

    mvn heroku:deploy
    
    