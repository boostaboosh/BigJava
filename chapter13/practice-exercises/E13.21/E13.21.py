# input
# int e.g. price 52
# bank notes e.g. 100, 20, 5, 1
# output
# e.g.
# 1,1,1,1,1,1...
# 20, 20, 5, 5, 1, 1
# 5,5,5,5,5,5,5,5,5,5,1,1
# etc.

ABANDON = 0
ACCEPT = 1
CONTINUE= 2

factors = [100, 20, 5, 1]
solutions = []

# this is the solve method
def getFactorCombinations(solution) :
	result = examine(solution)
	if (result == ACCEPT) :
		solutions.append(solution)
	elif (result == CONTINUE) :
		extendedSolutions = extend(solution)
		for partialSolution in extendedSolutions :
			getFactorCombinations(partialSolution)

def extend(partialSolution) :
	extendedSolutions = []
	for factor in factors :
		if (len(partialSolution) == 0 or factor <= partialSolution[-1]):
			copy = partialSolution[:]
			copy.append(factor)
			extendedSolutions.append(copy)
	return extendedSolutions
	
n = 52
def examine(partialSolution) :
	total = sum(partialSolution)
	if (total < n) :
		return CONTINUE
	elif (total == n):
		return ACCEPT
	else :
		return ABANDON
	
initialEmptySolution = []
getFactorCombinations(initialEmptySolution)
for solution in solutions:
	print(solution)
