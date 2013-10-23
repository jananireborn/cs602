import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
import java.util.zip.*;

/**
 * @author Janani Swaminathan
 * @version 1.0
 * @since 11/08/2012
 */

@SuppressWarnings("serial")
public class CompDecomp extends JApplet implements ActionListener {
	protected String inputDir, inputFile;
	private JButton BrowseButton;
	private JButton CompressButton;
	private JButton DecompressButton;
	private JComboBox jComboBox1;
	private JLabel jLabel1;
	private JTextField jTextField1;

	/**
	 * Called by the browser or applet viewer to inform this applet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the <code>start</code> method is called.
	 * <p>
	 * A subclass of <code>Applet</code> should override this method if it has
	 * initialization to perform. For example, an applet with threads would use
	 * the <code>init</code> method to create the threads and the
	 * <code>destroy</code> method to kill them.
	 * <p>
	 * The implementation of this method provided by the <code>Applet</code>
	 * class does nothing.
	 * 
	 * @see java.applet.Applet#destroy()
	 * @see java.applet.Applet#start()
	 * @see java.applet.Applet#stop()
	 */
	public void init() {

		Pane p = new Pane();
		getContentPane().add(p);

		jComboBox1.addActionListener(this);

		CompressButton.addActionListener(this);
		DecompressButton.addActionListener(this);
		BrowseButton.addActionListener(this);

	}

	class Pane extends JPanel {

		/**
		 * Pane Override method is for setting the grid and the layout property
		 * 
		 */
		public Pane() {

			setBackground(Color.lightGray);
			setLayout(new GridBagLayout());
			GridBagConstraints GrBagCon = new GridBagConstraints();
			new JInternalFrame();

			jLabel1 = new JLabel();
			jComboBox1 = new JComboBox();
			CompressButton = new JButton("Compress");
			DecompressButton = new JButton("Decompress");
			jTextField1 = new JTextField();
			jTextField1.setEditable(false);
			BrowseButton = new JButton("Browse");
			jLabel1.setText("Compression Format: ");

			jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "ZIP",
					"GZIP" }));

			/**
			 * Add the Buttons, Label and the text field
			 */
			GrBagCon.gridwidth = 2;
			GrBagCon.gridheight = 1;
			GrBagCon.insets = new Insets(3, 3, 3, 3);
			GrBagCon.gridy = 1;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(jLabel1, GrBagCon);
			add(jLabel1);

			GrBagCon.gridwidth = 2;
			GrBagCon.gridy = 3 / 2;

			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(jComboBox1, GrBagCon);
			add(jComboBox1);

			GrBagCon.gridwidth = 2;
			GrBagCon.gridy = 7 / 4;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout())
					.setConstraints(BrowseButton, GrBagCon);
			add(BrowseButton);

			GrBagCon.gridwidth = 3;
			GrBagCon.gridy = 3;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(CompressButton,
					GrBagCon);
			add(CompressButton);

			GrBagCon.gridwidth = 3;
			GrBagCon.gridy = 7 / 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(DecompressButton,
					GrBagCon);
			add(DecompressButton);

			GrBagCon.gridwidth = 6;
			GrBagCon.gridy = 4;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(jTextField1, GrBagCon);
			add(jTextField1);

		}
	}

	/**
	 * Method to handle the events and display the results in the text area
	 * Invoked when an action occurs.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == "Compress") {
			try {
				if (jComboBox1.getSelectedItem() == "ZIP") {
					ZipFile(jTextField1.getText(), jTextField1.getText()
							+ ".zip");
				} else {
					gZip(jTextField1.getText(), jTextField1.getText() + ".gzip");
				}
				jTextField1.setText("File compressed sucessfully");
			} catch (IOException ie) {
				jTextField1.setText(ie.getMessage());
			}
		} else if (cmd == "Decompress") {
			try {
				if (jComboBox1.getSelectedItem() == "ZIP") {
					unZipFile(jTextField1.getText(), jTextField1.getText()
							.substring(0, jTextField1.getText().length() - 4));
				} else {
					unGZipFile(jTextField1.getText(), jTextField1.getText()
							.substring(0, jTextField1.getText().length() - 5));
				}
				jTextField1.setText("File decompressed sucessfully");
			} catch (IOException ie) {
				jTextField1.setText(ie.getMessage());
			}
		} else if (cmd == "Browse") {
			try {
				FileDialog openDialog = new FileDialog(new Frame(),
						"Select Input File", FileDialog.LOAD);
				openDialog.setVisible(true);
				inputDir = openDialog.getDirectory();
				inputFile = openDialog.getFile();
				jTextField1.setText(inputDir + File.separator + inputFile);
			} catch (Exception ie) {
				jTextField1.setText(ie.getMessage());
			}
		}

	}

	/**
	 * Method to compress the file with .Zip format
	 * 
	 * @param inFilename
	 *            Input File name type String
	 * @param outFilename
	 *            output file name type String
	 */

	protected void ZipFile(String inFilename, String outFilename)
			throws IOException {
		// Create a buffer for reading the files
		byte[] buf = new byte[2048];

		try {
			// Create the ZIP file
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					outFilename));

			FileInputStream in = new FileInputStream(inFilename);

			// Add ZIP entry to output stream.
			out.putNextEntry(new ZipEntry(inFilename));

			// Transfer bytes from the file to the ZIP file
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			// Complete the entry
			out.closeEntry();
			in.close();

			// Complete the ZIP file
			out.close();
		} catch (IOException e) {
			throw (e);
		}

	}

	/**
	 * Method to decompress the file from .Zip format
	 * 
	 * @param inFilename
	 *            Input File name type String
	 * @param outFilename
	 *            output file name type String
	 */

	protected void unZipFile(String inFilename, String outFilename)
			throws IOException {
		try {
			// Open the ZIP file

			ZipInputStream in = new ZipInputStream(new FileInputStream(
					inFilename));

			in.getNextEntry();

			// Open the output file

			OutputStream out = new FileOutputStream(outFilename);

			// Transfer bytes from the ZIP file to the output file
			byte[] buf = new byte[2048];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			// Close the streams
			out.close();
			in.close();
		} catch (IOException e) {
			throw (e);
		}

	}

	/**
	 * Method to compress the file with .GZip format
	 * 
	 * @param inFilename
	 *            Input File name type String
	 * @param outFilename
	 *            output file name type String
	 */

	protected void gZip(String inFilename, String outFilename)
			throws IOException {
		try {
			// Create the GZIP output stream

			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(
					outFilename));

			// Open the input file

			FileInputStream in = new FileInputStream(inFilename);

			// Transfer bytes from the input file to the GZIP output stream
			byte[] buf = new byte[2048];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();

			// Complete the GZIP file
			out.finish();
			out.close();
		} catch (IOException e) {
			throw (e);
		}

	}

	/**
	 * Method to decompress the file with .GZip format
	 * 
	 * @param inFilename
	 *            Input File name type String
	 * @param outFilename
	 *            output file name type String
	 */

	protected void unGZipFile(String inFilename, String outFilename)
			throws IOException {
		try {
			// Open the compressed file

			GZIPInputStream in = new GZIPInputStream(new FileInputStream(
					inFilename));

			// Open the output file

			OutputStream out = new FileOutputStream(outFilename);

			// Transfer bytes from the compressed file to the output file
			byte[] buf = new byte[2048];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			// Close the file and stream
			in.close();
			out.close();
		} catch (IOException e) {
			throw (e);
		}

	}

}
