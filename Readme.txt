Campus Scooter Sharing System Version 1.0
Copyright (c) 2018-2019 Software Engineering Group84.
All rights reserved.

Campus Scooter Sharing System Version 1.0 is used in scooter docks and manager computers. After QM users register, they can borrow and return scooters at docks through the system. And system manager can use system to register new users and monitoring all the current state of docks and usage. They also can get users’ information and send email to users to inform them with usage information.

==========
 Contents
==========
0. Features
1. System requirements
2. Installation guide
3. Technical support

0. Features
===============================
  For manager
  - Help users register in the system
  - Check the usage of each user at any time
  - Send each user a weekly usage report via email
  - Monitor the status of each docking station

  For user
  - Pick up a scooter from the station
  - Return a scooter from the station
  - Pay for fine

1. System requirements
=======================
  - Processor		      Intel(R) compatible CPUs
  - OS                        Windows 98 or later
  - Main memory	              8M bytes (recommends 16M bytes or above)
  - Hard disk		      4M bytes
  - Video colors	      256 color or above
  - TCP/IP		      Winsock 1.1 or later

2. Installation guide
======================
  - Before you install the system, make sure that your computer has configured the JAVA environment.
  - There are instruction for you to install the system.
  - First, you need open the folder "group84"
  - Then you need to open the command line in group84 folder and input the following command:
    
       "cd src"
       "javac -d ../bin ./entity/*.java ./control/*.java ./boundary/*.java
       "cd .."
       "cd bin"
       "java boundary.MainGUITest"
    
    If there is error, please check your JAVA configuration.

3. Technical support
====================
   E-mail:
   2016213516@bupt.edu.cn

A campus Scooter Sharing System is registered of Group84.
