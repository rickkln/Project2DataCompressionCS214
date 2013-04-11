import os
import sys
import texttable as tt
filesGzip = ["aaaaaaaaaa.txt.gz","abbbaabbbbaccabbaaabc.txt.gz","abra.txt.gz","aesop-2copies.txt.gz","aesop-4copies.txt.gz","aesop.txt.gz","amendments.txt.gz","babble.txt.gz","bible.txt.gz","chromosome11-human.txt.gz","dickens.txt.gz","ecoli.txt.gz","lilwomen.txt.gz","manifesto.txt.gz","moby1.txt.gz","mobydick.txt.gz","muchado.txt.gz","nomatch.txt.gz","pi-10million.txt.gz","pi-1million.txt.gz","princeton.txt.gz","redundant-2copies.txt.gz","redundant.txt.gz","sedgewick-algc.txt.gz","sedgewick-algjava.txt.gz","sedgewick-speech.txt.gz","starr.txt.gz","world192.txt.gz","y2kintro.txt.gz"]
filesHuffman = ['aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt']
filesGzip.sort()
filesHuffman.sort()
print(len(filesHuffman)==len(filesGzip))
table = tt.Texttable()
print("THIS ASSUMSE THAT YOUR PROGRAM HAS PASSED ALL PREVIOUS BW MTF & GZ TESTS")
head = ["File","Your Size","Gzip Size","Ratio"]
table.header(head);
for i in range(len(filesGzip)):
    hufSize = os.stat(os.path.join("./h_files",filesHuffman[i])).st_size
    gzSize = os.stat(os.path.join("./gzip_files",filesGzip[i])).st_size
    table.add_row([filesGzip[i], hufSize,gzSize,float(hufSize)/gzSize])
print(table.draw())
