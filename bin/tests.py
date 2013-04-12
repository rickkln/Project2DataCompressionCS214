import sys
import os
import subprocess
import time

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
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'textfiles'
        testfolder = 'bw_files'
    elif direction == '+':
        commands = ('java BurrowsWheeler +',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt')
        infolder = 'bw_files'
        testfolder = 'textfiles'
elif algorithm == 'MTF':
    algorithm_name = 'Move-to-front'
    if direction == '-':
        commands = ('java MoveToFront -',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'bw_files'
        testfolder = 'mtf_files'
    elif direction == '+':
        commands = ('java MoveToFront +',)
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt', 'dickens.txt')
        infolder = 'mtf_files'
        testfolder = 'bw_files'
elif algorithm == 'GZ':
    algorithm_name = 'Gzip'
    if direction == '-':
        commands = ('java BurrowsWheeler -', 'java MoveToFront -', 'java Huffman -')
        filenames = ('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt')
        infolder = 'textfiles'
        testfolder = 'h_files'
    elif direction == '+':
        commands = ('java Huffman +', 'java MoveToFront +', 'java BurrowsWheeler +')
        filenames =('aaaaaaaaaa.txt', 'abra.txt', 'abbbaabbbbaccabbaaabc.txt', 'nomatch.txt', 'redundant.txt', 'redundant-2copies.txt', 'princeton.txt', 'moby1.txt', 'amendments.txt', 'y2kintro.txt', 'babble.txt', 'sedgewick-speech.txt', 'manifesto.txt', 'sedgewick-algc.txt', 'sedgewick-algjava.txt', 'muchado.txt', 'aesop.txt', 'starr.txt', 'aesop-2copies.txt', 'aesop-4copies.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'bible.txt', 'ecoli.txt', 'chromosome11-human.txt', 'pi-10million.txt')
        infolder = 'h_files'
        testfolder = 'textfiles'
else: abort_usage()

passed, failed = 0, 0
print '================================================================================'
print '\033[1mTesting %s %s\033[0m (%d tests)' % (algorithm_name, direction_name, len(filenames))
print '================================================================================'
t = time.time()
for f in filenames:
    print '', f.ljust(71),
    with open('%s/%s' % (infolder, f)) as infile, open('%s/%s' % (testfolder, f)) as testfile, open(os.devnull, 'w') as devnull:
        try:
            for command in commands[:-1]:
                infile = subprocess.Popen(command.split(), stdin=infile, stderr=devnull, stdout=subprocess.PIPE).stdout
            output = subprocess.check_output(commands[-1].split(), stdin=infile, stderr=devnull)
            if output == testfile.read():
                print '\033[92mpassed\033[0m'
                passed += 1
            else:
                print '\033[91mfailed\033[0m'
                failed += 1
        except subprocess.CalledProcessError:
            print '\033[91mfailed\033[0m'
            failed += 1
t = time.time() - t
print '================================================================================'
print 'Total time: %.2f seconds' % t
print '%s %d, %s %d, %s %d' % ('\033[1m\033[92mpassed\033[0m', passed, '\033[1m\033[91mfailed\033[0m', failed, '\033[1m\033[93mtotal\033[0m', len(filenames))
print '================================================================================'
