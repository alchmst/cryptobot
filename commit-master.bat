@ECHO OFF
Title Update Files
color f0
setlocal enableextensions disabledelayedexpansion
    for /f %%a in ('
        forfiles /p "%~dp0." /m "%~nx0" /c "cmd /c echo 0x1B"
    ') do set "ESC=%%a"

git init
git add .
git remote add origin https://github.com/alchmst/cryptobot.git
echo.
SET update_commit=
SET /P "update_commit=Commit value: "
echo.
git commit -m  "%update_commit%"
git push -f origin master
echo.
git status
echo.
echo %ESC%[32m
echo Update finished. . .%ESC%[0m
echo.
pause