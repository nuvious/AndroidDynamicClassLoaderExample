#!/bin/bash
javac Hello.java
jar cvf Hello.jar Hello.class
d8 Hello.jar
mv classes.dex app/src/main/res/raw/classes.dex
