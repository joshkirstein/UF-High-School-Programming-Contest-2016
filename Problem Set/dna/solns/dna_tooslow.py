def repeated(substring,start,fullString):
	for i in range(len(fullString)):
		for j in range(i+1,len(fullString)+1):
			if i == start or j - i < 2:
				continue
			if fullString[i:j] == substring:
				return True
	return False


tc = int(raw_input())
while tc:
	tc -= 1
	dna = raw_input()
	used = dict()
	maxLen = 0
	numMaxLen = 0
	for i in range(len(dna)):
		for j in range(i+1,len(dna)+1):
			if repeated(dna[i:j],i,dna) and ((j-i +1) >= maxLen) and not (dna[i:j] in used):
				used[dna[i:j]] = True
				if (j-i) > maxLen:
					maxLen = j - i
					numMaxLen = 1
				elif (j - i) == maxLen:
					numMaxLen += 1
	print maxLen, numMaxLen
