from osgeo import gdal
import numpy as np

def main():
    #start by getting the first raster (slope aspect)
    filepath1 = r"C:\Users\Griffin\Documents\TAMU_Classes\Flooding_Analysis\Code\aspectclip1.tif"
    aspectRaster = gdal.Open(filepath1)
    
    # Using the xy data from the raster, create a matrix of zeros
    grid = np.zeros((aspectRaster.RasterXSize, aspectRaster.RasterYSize), dtype = int)
        
    
    # Read the raster data into an array
    aspectMatrix = aspectRaster.ReadAsArray()
    
    print (aspectMatrix)
    
    # Begin the for loops to create your environment
    for uu in range(aspectRaster.RasterXSize):
        for ii in range(aspectRaster.RasterYSize):
            y = ii
            x = uu
            grid[uu][ii] += 1
            locations = []
            flag = True
            while flag == True:
                try:
                    if x < 0 or y < 0:
                        flag = False
                    elif (x, y) in locations:
                        flag = False                    
                    elif aspectMatrix[x][y] >= 320 or aspectMatrix[x][y] <= 40:
                        y = y - 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] > 40 and aspectMatrix[x][y] < 50:
                        x += 1
                        y = y - 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] >= 50 and aspectMatrix[x][y] <= 130:
                        x += 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] > 130 and aspectMatrix[x][y] < 140:
                        x += 1
                        y += 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] >= 140 and aspectMatrix[x][y] <= 220:
                        y += 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] > 220 and aspectMatrix[x][y] < 230:
                        x = x - 1
                        y += 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] >= 230 and aspectMatrix[x][y] <= 310:
                        y = x - 1
                        locations.append((x, y))
                        grid[x][y] += 1
                    elif aspectMatrix[x][y] > 310 and aspectMatrix[x][y] < 320:
                        x = x - 1
                        y = y - 1
                        locations.append((x, y))
                        grid[x][y] += 1
                        
                except IndexError:
                    flag = False

main()
