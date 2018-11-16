
Param
(
    [Parameter(Position=0,mandatory=$true)]
    [String]$Computer,
    [Parameter(Position=1,mandatory=$true)]
    [String]$Path
)


$ResultPath = $Path +"\"+$Computer+".csv"
$Origin = "\\" + $Computer + "\c$\scanner.csv"

Invoke-Command -Computername $Computer -ScriptBlock { Get-VM | select VMName, State, ComputerName | Export-CSV -path "c:\scanner.csv" -NoTypeInformation}

copy $Origin $ResultPath