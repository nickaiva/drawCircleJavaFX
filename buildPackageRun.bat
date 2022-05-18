REM https://stackoverflow.com/questions/60656844/how-to-solve-graphics-device-initialization-failed-for-d3d-sw-when-running
REM https://openjfx.io/openjfx-docs/#install-javafx
REM https://docs.oracle.com/en/java/javase/14/jpackage/manage-installation.html#GUID-832F848E-E074-476C-A203-F081D0407081

REM STEPS TO CREATE AN INSTALLATION PACKAGE FOR WINDOWS Based on page 433 of JavaFX The definitive guide
cd G:\MyWork\eclipse-workspace\drawCircleJavaFX
dir /s /b src\*.java > sources.txt & javac --module-path %PATH_TO_FX_MODS% -d mods/drawCircleJavaFX @sources.txt & del sources.txt
jlink --module-path "%PATH_TO_FX_MODS%;mods" --add-modules drawCircleJavaFX --output image
cd image\bin
java -m drawCircleJavaFX/drawCircleJavaFX.DrawCircle
cd..
cd..
jpackage  --type msi -n drawCircle -m drawCircleJavaFX/drawCircleJavaFX.DrawCircle --icon assets/nickaiva.ico --win-shortcut --win-dir-chooser --runtime-image image --win-shortcut --win-menu --win-menu-group "Apps by NickAiva" --description "Draw circle application "   --vendor "Nick Aiva" --copyright "Copyright 2022, All rights reserved" --app-version 1.1 --license-file licence.txt


REM java --module-path "E:\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml  -jar drawCircle.jar
REM java  --add-modules javafx.controls,javafx.fxml  -jar drawCircle.jar