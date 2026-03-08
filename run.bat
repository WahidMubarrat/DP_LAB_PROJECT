@echo off
REM ============================================================
REM  Racing In IUT - Build & Run Script
REM  Requires JDK 17 (or any JDK 11+) in PATH.
REM  If javac is not on PATH, set JAVA_HOME below.
REM ============================================================

SET "JAVA_HOME=C:\Program Files\Java\jdk-17"
SET "PATH=%JAVA_HOME%\bin;%PATH%"

echo.
echo  Compiling Racing In IUT...
echo  ============================================================

IF NOT EXIST out mkdir out

javac -encoding UTF-8 -d out -sourcepath src ^
    src\racing\strategy\EngineBehavior.java ^
    src\racing\strategy\V6Engine.java ^
    src\racing\strategy\V8Engine.java ^
    src\racing\strategy\V12Engine.java ^
    src\racing\strategy\TurbochargerBehavior.java ^
    src\racing\strategy\AlpineTurbocharger.java ^
    src\racing\strategy\CumminsTurbocharger.java ^
    src\racing\strategy\HoneywellTurbocharger.java ^
    src\racing\car\Car.java ^
    src\racing\car\Coupe.java ^
    src\racing\car\Roadster.java ^
    src\racing\car\ToyotaGR86.java ^
    src\racing\car\SubaruBRZ.java ^
    src\racing\car\PorscheBoxster.java ^
    src\racing\car\Ferrari812.java ^
    src\racing\factory\CarFactory.java ^
    src\racing\factory\CoupeFactory.java ^
    src\racing\factory\RoadsterFactory.java ^
    src\racing\factory\TrackFactory.java ^
    src\racing\track\Track.java ^
    src\racing\track\BlueMoonBaySpeedway.java ^
    src\racing\track\BBRaceway.java ^
    src\racing\track\CircuitDeSpaFrancorchamps.java ^
    src\racing\singleton\Player.java ^
    src\racing\decorator\CarDecorator.java ^
    src\racing\decorator\ResonacNOS.java ^
    src\racing\decorator\SemaNOS.java ^
    src\racing\race\Race.java ^
    src\racing\race\SprintRace.java ^
    src\racing\race\CircuitRace.java ^
    src\racing\Rii.java

IF %ERRORLEVEL% NEQ 0 (
    echo.
    echo  [ERROR] Compilation failed. See errors above.
    pause
    exit /b 1
)

echo  Compilation successful!
echo  ============================================================
echo.
echo  Launching game...
echo.

java -cp out racing.Rii

echo.
pause
