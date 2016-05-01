numLines = int(raw_input())
while numLines:
	numLines -= 1
	currLine = raw_input().lower()
	total = 0
	for i in currLine:
		if i in 'aeiou':
			total += 1
	print total