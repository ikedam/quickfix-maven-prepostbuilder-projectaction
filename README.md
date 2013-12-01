Quickfix Maven Prepostbuilder Projectaction plugin
==================================================

Quickfix to call getProjectAction for prebuilders and postbuilders of MavenModuleSet

About
-----

Some builders (e.g. [Parameterized Trigger Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Parameterized+Trigger+Plugin))
generates entries displayed in status page (they are called "Action" in Jenkins).

Builders in "Pre Steps" and "Post Steps" of Maven 2/3 Project are not handled properly for the above feature.
This results entries by builders are not properly displayed in project status page.

This plugin provides a quickfix for this problem.

How to Install
--------------

See [Jenkins update center for ikedam plugins](http://ikedam.github.com/jenkins-update-center/), and follow the instruction to have your Jenkins to access my update center.

