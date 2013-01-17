@echo off
"C:\Program Files (x86)\Java\jre7\bin\java" -Xms64m -Xmx512m -Djava.library.path="D:\Projets\javaApplication\lib\lwjgl-2.8.5\native\windows" -jar pongX.jar pongx.PongX
::java -Xms64m -Xmx512m -cp pongX.jar pongx.PongX %1 %2 %3 %4 %5 %6 %7 %8
::if errorlevel 1 pause
