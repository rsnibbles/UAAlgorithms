JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	LongestCommonSubstring.java \
	TestLongestCommonSubstring.java \
	RunTest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class