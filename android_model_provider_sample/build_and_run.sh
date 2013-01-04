ant debug -Dsource.dir=src:tests
ant installd
ant test -Dtest.runner=com.uphyca.testing.JUnit4InstrumentationTestRunner
