import sys
import os
import subprocess
import time
import tempfile
ntf =  tempfile.NamedTemporaryFile


#('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')

def abort_usage():
    print 'Usage: %s BW|MTF|GZ -|+' % sys.argv[0]
    exit()

if len(sys.argv) != 3:
    abort_usage()

algorithm = sys.argv[1]
direction = sys.argv[2]

if direction == '-':
    direction_name = 'encoding'
elif direction == '+':
    direction_name = 'decoding'
else:
    abort_usage()

if algorithm == 'BW':
    algorithm_name = 'Burrows-Wheeler'
    if direction == '-':
        commands = ('java BurrowsWheeler -',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt')
        infolder = 'textfiles'
        testfolder = 'bw_files'
    elif direction == '+':
        commands = ('java BurrowsWheeler +',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'bw_files'
        testfolder = 'textfiles'
elif algorithm == 'MTF':
    algorithm_name = 'Move-to-front'
    if direction == '-':
        commands = ('java -Xmx1500m MoveToFront -',)
        filenames =('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'bw_files'
        testfolder = 'mtf_files'
    elif direction == '+':
        commands = ('java -Xmx1500m MoveToFront +',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'mtf_files'
        testfolder = 'bw_files'
elif algorithm == 'GZ':
    algorithm_name = 'Gzip'
    if direction == '-':
        commands = ('java -Xmx1500m BurrowsWheeler -', 'java -Xmx1500m MoveToFront -', 'java -Xmx1500m Huffman -')
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt')
        infolder = 'textfiles'
        testfolder = 'h_files'
    elif direction == '+':
        commands = ('java -Xmx1500m  Huffman +', 'java -Xmx1500m MoveToFront +', 'java -Xmx1500m BurrowsWheeler +')
        filenames =('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'h_files'
        testfolder = 'textfiles'
else: abort_usage()

passed, failed = 0, 0
print '================================================================================'
print '\033[1mTesting %s %s\033[0m (%d tests)' % (algorithm_name, direction_name, len(filenames))
print '================================================================================'
t = time.time()
data = {}
for f in filenames:
    print '', f.ljust(71),
    with open('%s/%s' % (infolder, f)) as infile, open('%s/%s' % (testfolder, f)) as testfile, open(os.devnull, 'w') as devnull:
        try:
            temp_file = ntf(mode="w")
            start_time = time.time()
            for command in commands[:-1]:
                infile = subprocess.Popen(command.split(), stdin=infile, stderr=devnull, stdout=subprocess.PIPE).stdout
            if(not data.has_key(f)):
                data[f] = []
            output = subprocess.check_output(commands[-1].split(), stdin=infile, stderr=devnull)
            data[f] = data[f] +[time.time() -start_time,os.stat(os.path.join("textfiles",f)).st_size]
            temp_file.write(output)
            temp_file.flush()
            os.fsync(temp_file)
            data[f] = data[f] + [os.stat(temp_file.name).st_size]
            data[f] = data[f] + [float(data[f][2])/data[f][1]]
            temp_file.close()
            start = 4 if algorithm == 'BW' and direction == '-' else 0 #index may differ for redundant inputs
            if output[start:] == testfile.read()[start:]:
                print '\033[92mpassed\033[0m'
                passed += 1
            else:
                print '\033[91mfailed\033[0m'
                failed += 1
        except subprocess.CalledProcessError:
            print '\033[91mfailed_no_run\033[0m'
            failed += 1
t = time.time() - t
print '================================================================================'
print 'Total time: %.2f seconds' % t
print '%s %d, %s %d, %s %d' % ('\033[1m\033[92mpassed\033[0m', passed, '\033[1m\033[91mfailed\033[0m', failed, '\033[1m\033[93mtotal\033[0m', len(filenames))
print '================================================================================'
import texttable as tt
print("ANALYSIS")
head = ["File", "Runtime","Original Size","New File Size","Ratio"]
table = tt.Texttable()
table.header(head);
data = data.items()
data.sort()
for i in data:
    table.add_row([i[0]] + i[1])
print(table.draw())
    
