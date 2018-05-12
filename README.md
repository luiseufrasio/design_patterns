# design_patterns
Design Patterns implementation in some programming languages

# Nice links
<ul>
  <li>https://refactoring.guru/design-patterns</li>
  <li>https://www.youtube.com/watch?v=wAX8VA7FH8M (Design Patterns in Typescript)</li>
</ul>

# Compilation example
javac Java/creational/factory/method/*.java -d bin/

# Execution example
cd bin
java creational.factory.method.FactoryMethodMain

# Update to java 10
sudo add-apt-repository ppa:linuxuprising/java
sudo apt-get update
sudo apt-get install oracle-java10-installer

# Create JAVA_HOME and include it in the PATH


    find /usr/lib/jvm/java-1.x.x-openjdk

    vim /etc/profile

    Prepend sudo if logged in as not-privileged user, ie. sudo vim
    Press 'i' to get in insert mode

    add:

    export JAVA_HOME="path that you found"

    export PATH=$JAVA_HOME/bin:$PATH

    reopen shell or use source /etc/profile to apply changes immediately

