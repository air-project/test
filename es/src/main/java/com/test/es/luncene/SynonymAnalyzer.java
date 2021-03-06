package com.test.es.luncene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class SynonymAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        StandardTokenizer source = new StandardTokenizer();
        return new TokenStreamComponents(source, new SynonymFilter(new StopFilter(new LowerCaseFilter(source),
                new CharArraySet(StopAnalyzer.ENGLISH_STOP_WORDS_SET, true)), new TestSynonymEngine()));
    }
}