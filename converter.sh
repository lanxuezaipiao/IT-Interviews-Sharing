#!/bin/bash
# vim file.txt -c "e ++enc=GB18030"
# :set fileencoding=utf-8
for i in `find . -name '*.md'`
do
if test -f $i
then
touch temp.md
iconv -f gb18030 -t utf8 $i > temp.md
cp temp.md $i
rm temp.md
fi
done
