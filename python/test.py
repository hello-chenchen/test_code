import urllib

file = open("test.txt")
for line in file:
    print(line.strip())
file.close()