package com.example.color;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.example.colors.ColorBatchPool;
import com.example.colors.PaintManager;

public class PaintManagerTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	PaintManager paintManager = new PaintManager();

	@Test
	public void testNoSolution() throws IOException {
		final String filePath = this.getClass().getClassLoader().getResource("noSolution.txt").getPath();
		paintManager.managePaint(filePath);
	}

	@Test
	public void testRicherSolution() throws IOException {
		final String filePath = this.getClass().getClassLoader().getResource("richerTest.txt").getPath();
		paintManager.managePaint(filePath);
		final String output = ColorBatchPool.instance().getColorPool().values().stream().map(n -> n.getSymbol())
				.collect(Collectors.joining(" "));
		assertEquals("G M G M G", output);
	}

	@Test
	public void testSimple() throws IOException {
		final String filePath = this.getClass().getClassLoader().getResource("testSimple.txt").getPath();
		paintManager.managePaint(filePath);
		final String output = ColorBatchPool.instance().getColorPool().values().stream().map(n -> n.getSymbol())
				.collect(Collectors.joining(" "));
		assertEquals("G G G G M", output);
	}

	@Test
	public void testOneMore() throws IOException {
		final String filePath = this.getClass().getClassLoader().getResource("onemore.txt").getPath();
		paintManager.managePaint(filePath);
		final String output = ColorBatchPool.instance().getColorPool().values().stream().map(n -> n.getSymbol())
				.collect(Collectors.joining(" "));
		assertEquals("M M", output);
	}
}
