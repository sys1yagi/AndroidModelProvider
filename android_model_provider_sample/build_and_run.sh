ant uninstall
ant clean
ant debug -Dsource.dir=src:tests -Djava.target=jsr14 -Djava.source=1.7
#ant debug -Dsource.dir=src:tests -Djava.target=jsr14 -Djava.source=1.7
ant installd
ant test -Dtest.runner=com.uphyca.testing.JUnit4InstrumentationTestRunner
