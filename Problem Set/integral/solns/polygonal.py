tc = int(raw_input())
for case in range(tc):
	numPoints = int(raw_input())
	points = []
	total = 0.0
	for i in range(numPoints):
		points.append([int(x) for x in raw_input().split()])
	for i in range(numPoints-1):
		total += ((points[i][1]+points[i+1][1])/2.0)*(points[i+1][0]-points[i][0])
	print("{0:.2f}".format(total))