import os
import numpy as np
import pandas as pd
from subprocess import Popen, PIPE, STDOUT

class AnalyzeSorts:
    def __init__(self):
        self.runs = {"sorted":{"merge":[],"quick":[],"heap":[]}, "unsorted":{"merge":[],"quick":[],"heap":[]},"reversed":{"merge":[],"quick":[],"heap":[]}}
        self.current = []
        

    def run(self, timesToRun):
        for i in range(timesToRun):
            print("{0} item{1} in the array".format(i+1, "s" if i+1 > 1 else ""))
            self.status = "unsorted"
            self.generateArray(1, 10000, i+1)
            self.executeJava()
            self.organizeData()
            
            self.status = "sorted"
            self.arr=np.sort(self.arr)
            self.executeJava()
            self.organizeData()

            self.status = "reversed"
            self.arr=np.sort(self.arr)[::-1]
            self.executeJava()
            self.organizeData()

    def generateArray(self, begin, end, size):
        self.arr = np.random.randint(begin,end,size)

    def executeJava(self):
        array = ','.join(str(val) for val in self.arr)
        os.system("javac Sorter.java")
        p = Popen(["java", "Sorter", array],stdout=PIPE)
        for line in p.stdout:
            self.current.append(line.strip().decode("utf-8")) 

    def organizeData(self):
        mergeSort = self.current[0]
        self.runs[self.status]["merge"].append(int(mergeSort[mergeSort.find(": ")+1:]))

        quickSort = self.current[1]
        self.runs[self.status]["quick"].append(int(quickSort[quickSort.find(": ")+1:]))

        heapSort = self.current[2]
        self.runs[self.status]["heap"].append(int(heapSort[heapSort.find(": ")+1:]))
        self.current = []

    def saveData(self):
        writer = pd.ExcelWriter("SortingAlgorithms.xlsx")
        for category in self.runs:
            dataFrame = pd.DataFrame(self.runs[category])
            dataFrame.to_excel(writer, category)
        writer.save()
        print("Successfully calculated time for each algorithm")
        


if __name__ == '__main__':
    a = AnalyzeSorts()
    a.run(1000)
    a.saveData()
