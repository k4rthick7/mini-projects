power = int(input("Enter Player Power! "))
monster = int(input("No Of Monsters? "))
monsters = []
kill = 0

while monster != 0:
    mp = int(input("Enter Monster Power: "))
    mb = int(input("Monster Bonus: "))
    monsters.append((mp, mb))
    monster -= 1

monsters.sort(key=lambda x: x[0])
print(monsters)

for mp, mb in monsters:
    if power >= mp:
        power += mb
        kill += 1
        print(f"Monster killed! Current power: {power}")
    else:
        print(f"Unable to kill! Current power: {power}")

print(f"{kill} Monsters were killed")
