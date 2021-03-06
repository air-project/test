package com.test.arithmetic.bp.bp;


import com.test.arithmetic.bp.data.Dataset;
import com.test.arithmetic.bp.data.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpTest {
	public static void testArray() {
		List<Double> data = new ArrayList<Double>(4);
		data.set(0, 0.3);
		data.add(0.0);
		data.add(1.0);
		data.add(2.0);
		data.add(3.0);
		data.add(3.0);
		System.out.println(data);
	}

	public static void testArrayOrder() {
		int m = 10000;
		int n = 1000;
		long start = System.currentTimeMillis();
		double[][] data = new double[m][n];
		for (int j = 0; j < n; j++)
			for (int i = 0; i < m; i++)
				data[i][j] = Math.sqrt(i * Math.PI % j * i) / Math.E;
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void testBinary(int n) {
		Double lable = 7.0;
		String binary = Integer.toBinaryString(lable.intValue());
		System.out.println(binary);
		System.out.println(Arrays.toString(binary.getBytes()));
		byte[] bytes = binary.getBytes();
		int[] encode = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < bytes.length)
				encode[i] = bytes[i] - '0';
			else
				encode[i] = 0;
		}
		System.out.println(Arrays.toString(encode));
	}
	public static void testBP(){
		String fileName = "data/poker-hand-training-order.txt";
		Dataset dataset = Dataset.load(fileName, ",", 10,false);
		BPNetwork bp = new BPNetwork(new int[]{10,80,4},true);
		bp.trainModel(dataset,0.98);
//		String testName = "data/poker-hand-test-order.nolable";
//		Dataset testset = Dataset.load(testName, ",", -1);
//		String outName = "data/test.predict";
//		bp.predict(testset,outName);
		
		String testName = "data/poker-hand-test-order.csv";
		Dataset testset = Dataset.load(testName, ",", 10,false);
		double p = bp.test(testset);
		
	}
	
	
	public static void testHandWirte(){
		String fileName = "data/train.format";
		Dataset dataset = Dataset.load(fileName, ",", 784,false);
		BPNetwork bp = new BPNetwork(new int[]{784,100,4},true);
		bp.trainModel(dataset,0.99);
		dataset= null;
		String testName = "data/test.format";
		Dataset testset = Dataset.load(testName, ",", -1,false);
		String outName = "data/test.predict";
		bp.predict(testset,outName);
	}
	
	public static void testPinan(){
		String fileName = "data/train_second_stage.csv";
		Dataset dataset = Dataset.load(fileName, ",", 688,true);
		BPNetwork bp = new BPNetwork(new int[]{688,100,4},true);
		bp.trainModel(dataset,0.99);
//		dataset= null;
//		String testName = "data/test.format";
//		Dataset testset = Dataset.load(testName, ",", -1,false);
//		String outName = "data/test.predict";
//		bp.predict(testset,outName);
	}
	
	public static void testAotuEncode(){
		String fileName = "data/train-hw.split";
		Dataset dataset = Dataset.load(fileName, ",", 784,false);
		BPNetwork bp = new BPNetwork(new int[]{784,20,4},true);
		bp.trainModel(dataset,0.995);
		dataset= null;
		String testName = "data/test-hw.split";
		Dataset testset = Dataset.load(testName, ",", 784,false);	
		bp.test(testset);
	}
	public static void testTest(){
		Test t = new Test();
		double[] d = t.getData();
		for(int i=0;i<d.length;i++)
			d[i] = i*i;
		t.print();
	}
	
	public static void testTinyNet(){
		String modelName = "data/tiny.model";
		BPNetwork bp = BPNetwork.loadModel(modelName);
		String fileName = "data/tiny.txt";
		Dataset dataset = Dataset.load(fileName, ",", 3,false);
		bp.trainModel(dataset,0.98);
		
	}
	/**
	 * ���ֿ����ѵ��
	 */
	public static void testWords(){
		String fileName = "data/3500.db";
		Dataset dataset = Dataset.load(fileName, ",", 1024,false);
		BPNetwork bp = new BPNetwork(new int[]{1024,150,12},true);	
		//BPNetwork bp = BPNetwork.loadModel("model/testWords.model");
		bp.trainModel(dataset,0.85);
//		String testName = "data/3510_make.txt";
//		Dataset testset = Dataset.load(testName, ",", 1024);	
//		bp.test(testset);
//		bp.saveModel("model/testWords.model");
	}
	
	public static void testMove(){
		int lable = 14;
		System.out.println((1<<(4-1)));
		lable = lable - (1<<(4-1));
		System.out.println(lable);
	}
	
	/**
	 * ���Կ��ŵ�����
	 */
	public static void testIdCarddDital(){
		String fileName = "data/625.merge.balance.shuffle";
		Dataset dataset = Dataset.load(fileName, ",", 1024,false);
		BPNetwork bp = new BPNetwork(new int[]{1024,100,4},true);
		bp.setLables("data/idcard.index");
	//	BPNetwork bp = BPNetwork.loadModel("model/model1438.model");
		bp.trainModel(dataset,0.999);
		
		
		String testName = "data/idcard_digit.xiong.shuffle.all";
		Dataset testset = Dataset.load(testName, ",", 1024,false);	
		//bp.test(testset);
		//List<String> out = bp.predict(testset);
	//	System.out.println(out);
		bp.saveModel("model/model1438.model");
		ConcurenceRunner.stop();
	}
	/**
	 * �����Ա�
	 */
	public static void testSex(){
		String fileName = "data/625.sex.shuffle";
		Dataset dataset = Dataset.load(fileName, ",", 1024,false);
		BPNetwork bp = new BPNetwork(new int[]{1024,30,1},true);		
		bp.setLables("data/index.sex");
		//BPNetwork bp = BPNetwork.loadModel("model/model1438.model");
		bp.trainModel(dataset,2);		
		bp.saveModel("model/sex.model");
		ConcurenceRunner.stop();
	}
	public static void testName(){
		String fileName = "data/626.name";
		Dataset dataset = Dataset.load(fileName, ",", 1024,false);
		BPNetwork bp = new BPNetwork(new int[]{1024,6,6},true);		
		bp.setLables("data/index.name");
		//BPNetwork bp = BPNetwork.loadModel("model/model1438.model");
		bp.trainModel(dataset,2);		
		bp.saveModel("model/name.model");
		ConcurenceRunner.stop();
	}
	
	
	public static void testAddr(){
		String fileName = "data/626.addr.shuffle";
		Dataset dataset = Dataset.load(fileName, ",", 1024,false);
		BPNetwork bp = new BPNetwork(new int[]{1024,80,8},true);		
		bp.setLables("data/index.addr");
		//BPNetwork bp = BPNetwork.loadModel("model/model1438.model");
		bp.trainModel(dataset,2);		
		bp.saveModel("model/addr.model");
		ConcurenceRunner.stop();
	}
	
	public static void testLogFunc(){
		String fileName = "data/func_train.txt";
		Dataset dataset = Dataset.load(fileName, "\t", 2,false);
		BPNetwork bp = new BPNetwork(new int[]{2,1000,1},false);
		bp.trainModel(dataset,1);
		dataset= null;
		String testName = "data/func_test.txt";
		Dataset testset = Dataset.load(testName, "\t",2,false);
		String outName = "data/zjw_test.predict";
		bp.predict(testset,outName);
	}
	
	public static void main(String[] args) {
		// testArray();
		// testArrayOrder();
		//testBinary(5);
		//testBP();
		//testTest();
		//testTinyNet();
		//testHandWirte();
		//testAotuEncode();
		//testMove();
		//testWords();
		//testIdCarddDital();
		//testSex();
		//testName();
		//testAddr();
		//testPinan();
		testLogFunc();
	}

}
