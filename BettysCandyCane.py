import sys
# endX, endY = map(int,input().strip().split(" ")) 
endX, endY = [int(x) for x in input().split()]
grid = [
  ['B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'], 
  [' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' '], 
  [' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' '], 
  ['X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '], 
  [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
  ['X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' '],
  [' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '],
  [' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
  [' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' '],
  [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X']
]
defVal = sys.maxsize
dist = [[defVal, defVal, defVal]]
for i in range(0, 10):
  dist.append([])
  for j in range (0, 10):
    dist[i].append(defVal)
    if grid [i][j] == 'B':
      dist [i][j] = 0
      startX = j #only needed if B is a random value
      startY = i
    elif grid [i][j] == 'X':
      dist [i][j] = -1

xQueue = [0]
yQueue = [0]
xQueue.append(startX)
yQueue.append(startY)
while len(xQueue) > 0:
  x = xQueue[0]
  del xQueue[0]
  y = yQueue[0]
  del yQueue[0]
  if grid [y][x] == 'B' or grid [y][x] == ' ':
    if y + 1 < 10:
      if dist [y + 1][x] == defVal:
        dist [y + 1][x] = dist [y][x] + 1
        xQueue.append(x)
        yQueue.append(y + 1)
    if x + 1 < 10:
      if dist [y][x + 1] == defVal:
        dist [y][x + 1] = dist [y][x] + 1
        xQueue.append(x + 1)
        yQueue.append(y)
    if y - 1 > -1:
      if dist [y - 1][x] == defVal:
        dist [y - 1][x] = dist [y][x] + 1
        xQueue.append(x)
        yQueue.append(y - 1)
    if x - 1 > -1:
      if dist [y][x - 1] == defVal:
        dist [y][x - 1] = dist [y][x] + 1
        xQueue.append(x - 1)
        yQueue.append(y)

# for i in range (10):
  # print(dist[i])

print ("Betty will sweat " + str(dist[endY - 1][endX - 1]) + "ml to get to her candy cane")
  

