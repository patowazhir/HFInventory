Param
(
    [Parameter(Mandatory = $true)]
    [String]$Computer,
    [String]$Path
)

$ResultPath = $Path +"\"+$Computer+".csv"
$Origin = "\\" + $Computer + "\c$\scanner.csv"

Invoke-Command -Computername $Computer -ScriptBlock { get-vm | Export-CSV c:\scanner.csv}

copy $Origin $ResultPath