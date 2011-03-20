js-maven
========

node-mojos
----------

Run a node.js script/server during a maven build.

    <plugin>
      <groupId>js-maven</groupId>
      <artifactId>node-mojos</artifactId>
      <version>1.0-SNAPSHOT</version>
      <executions>
        <execution>
          <phase>verify</phase>
          <goals>
            <goal>run</goal>
          </goals>
          <configuration>
            <file>node-test-suite.js</file>
          </configuration>
        </execution>
      </executions>
    </plugin>