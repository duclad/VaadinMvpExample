# vaadin-spring
VaadinSpring based example project with MVP integration
==============

Template for a full-blown Vaadin Spring application that can be executed on Jetty or Tomcat supporting Java 8.

Project Structure
=================

* vaadin-spring-parent: project property and sub module definitions
* vaadin-spring-common: project containing dependencies needed by both, UI layer and Backend layer such as Service interfaces
* vaadin-spring-backend: project containing the backend bean implementations
* vaadin-spring-ui: project containing Vaadin UI
* vaadin-spring-deploy: Deployable war project that overlays devday-ui. Overlaying is done to avoid direct dependencies from UI project to Backend project on code level but still to include also the backend's jar file to deployable artifact.


Getting started
=================

* mvn clean install vaadin-spring-parent project and if necessary skip tests to avoid running Vaadin TestBench tests.
* Open in IDE of your choice and deploy vaadin-spring-deploy project to Servlet container supporting Java 8
* Start up with browser from localhost:8080/vaadin-spring-deploy (or other user configured url)
