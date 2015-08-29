package com.ufgov.gk.client.component;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.MimeMapping;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.smartclient.plaf.BigButtonSplitPaneUI;

public class FileUploader extends JTextField {

  private FileUploader self = this;

  private boolean fileEditable = true;

  private boolean isDelFileButton = true;

  private boolean isDownloadFileButton = true;

  private boolean isUploadFileButton = true;

  public boolean isDelFileButton() {
    return isDelFileButton;
  }

  public void setDelFileButton(boolean isDelFileButton) {
    this.isDelFileButton = isDelFileButton;
  }

  public boolean isDownloadFileButton() {
    return isDownloadFileButton;
  }

  public void setDownloadFileButton(boolean isDownloadFileButton) {
    this.isDownloadFileButton = isDownloadFileButton;
  }

  public boolean isUploadFileButton() {
    return isUploadFileButton;
  }

  public void setUploadFileButton(boolean isUploadFileButton) {
    this.isUploadFileButton = isUploadFileButton;
  }

  public boolean isDeleteOldFile() {
    return isDeleteOldFile;
  }

  public void setDeleteOldFile(boolean isDeleteOldFile) {
    this.isDeleteOldFile = isDeleteOldFile;
  }

  private boolean isDeleteOldFile = false;

  private String absoluteFile = "";

  /**
   * 
   */
  private static final long serialVersionUID = -2259487467049441348L;

  /**
  * Logger for this class
  */
  private static final Logger logger = Logger.getLogger(FileUploader.class);

  private JButton uploadButton = new JButton(new ImageIcon(this.getClass().getResource("/img/fileupload/upload.jpg")));

  private JButton deleteButton = new JButton(new ImageIcon(this.getClass().getResource("/img/fileupload/delete.jpg")));

  private JButton downloadButton = new JButton(new ImageIcon(this.getClass().getResource("/img/fileupload/download.jpg")));

  private BigDecimal maxSizeM = new BigDecimal(500);

  private boolean sizeLimit = true;

  private String defaultSavePath = "C:/";

  IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
    "baseDataServiceDelegate");

  RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private String[] fileExt;

  public String[] getFileExt() {
    return fileExt;
  }

  public void setFileExt(String[] fileExt) {
    this.fileExt = fileExt;
  }

  public boolean isAllFileFilterUsed() {
    return isAllFileFilterUsed;
  }

  public void setAllFileFilterUsed(boolean isAllFileFilterUsed) {
    this.isAllFileFilterUsed = isAllFileFilterUsed;
  }

  private boolean isAllFileFilterUsed = true;

  private AsFile asFile;

  public FileUploader() {
    super(40);
    initUI();
  }

  public FileUploader(int columns) {
    super(columns);
    initUI();
  }

  public FileUploader(boolean isDeleteOldFile) {
    super(40);
    this.isDeleteOldFile = isDeleteOldFile;
    initUI();
  }

  /**
   * 
   * @param uploadFileButton �ϴ���ť�Ƿ����
   * @param delFileButton ɾ����ť�Ƿ����
   * @param downloadFileButton ���ذ�ť�Ƿ����
   * @param isDeleteOldFile
   */
  public FileUploader(boolean uploadFileButton, boolean delFileButton, boolean downloadFileButton, boolean isDeleteOldFile) {
    super(40);
    this.isUploadFileButton = uploadFileButton;
    this.isDelFileButton = delFileButton;
    this.isDownloadFileButton = downloadFileButton;
    this.isDeleteOldFile = isDeleteOldFile;
    initUI();
  }

  private void initUI() {
    this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    uploadButton.setBorderPainted(false);
    uploadButton.setPreferredSize(new Dimension(18, 15));
    uploadButton.setFocusable(false);
    uploadButton.setToolTipText("�ϴ��ļ�");

    deleteButton.setBorderPainted(false);
    deleteButton.setPreferredSize(new Dimension(18, 15));
    deleteButton.setFocusable(false);
    deleteButton.setToolTipText("ɾ���ļ�");

    downloadButton.setBorderPainted(false);
    downloadButton.setPreferredSize(new Dimension(18, 15));
    downloadButton.setFocusable(false);
    downloadButton.setToolTipText("�����ļ�");

    //    setBorder(BorderFactory.createEmptyBorder());
    super.setEditable(false);
    setBackground(Color.white);
    setPreferredSize(new Dimension(0, 20));

    this.add(uploadButton);
    //    JSeparator separator=  new JSeparator(SwingConstants.VERTICAL ) ;
    //    this.add(separator);

    this.add(deleteButton);
    JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
    this.add(separator2);
    this.add(downloadButton);
    //    this.setBorder(BorderFactory.createEtchedBorder());
    //    this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    uploadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUpload();
      }
    });

    downloadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doDownload();
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int yesNoResult = JOptionPane.showConfirmDialog(self, "�Ƿ�ȷ��ɾ����", "ɾ��ȷ��", JOptionPane.YES_NO_OPTION);
        if (yesNoResult == JOptionPane.YES_OPTION) {
          doDelete();
        }

      }
    });
    if (this.getFileId() != null && this.getFileId().trim().length() > 0) {
      this.deleteButton.setVisible(true);
      this.downloadButton.setVisible(true);
    } else {
      deleteButton.setVisible(false);
      downloadButton.setVisible(false);
    }

    setButtonEnable();

  }

  private void setFileId2(String fileId, boolean editable) {
    if (fileId == null || fileId.trim().equals("")) {
      asFile = null;
      this.setText("");
      this.setToolTipText(null);

      if (editable) {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(fileEditable);
      } else {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(false);
      }

      return;
    }
    /* */
    try {

      asFile = baseDataServiceDelegate.getAsFileById(fileId, requestMeta);
      if (asFile == null) {
        //        JOptionPane.showMessageDialog(this, "û���ҵ�idΪ" + fileId + "���ļ�\n" + "���ļ������ѱ�ɾ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("û���ҵ�idΪ" + fileId + "���ļ�\n" + "���ļ������ѱ�ɾ����");
        return;
      }

      this.setText(asFile.getFileName());
      this.setToolTipText(asFile.getFileName());

      if (editable) {
        deleteButton.setVisible(fileEditable);
        downloadButton.setVisible(fileEditable);
        uploadButton.setVisible(this.isDeleteOldFile);
        setButtonEnable();
      } else {
        deleteButton.setVisible(false);
        downloadButton.setVisible(true);
        uploadButton.setVisible(false);
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      JOptionPane.showMessageDialog(this, "ȡ�ļ���Ϣʱ�����쳣��", "����", JOptionPane.ERROR_MESSAGE);
    }

    /*asFile = new AsFile();
    asFile.setFileId(fileId);
    if (editable) {
      deleteButton.setVisible(fileEditable);
      downloadButton.setVisible(fileEditable);
      uploadButton.setVisible(this.isDeleteOldFile);
      setButtonEnable();
    } else {
      deleteButton.setVisible(false);
      downloadButton.setVisible(true);
      uploadButton.setVisible(false);
    }*/
  }

  private void setFileId3(String fileId, String fileName, boolean editable) {
    if (fileId == null || fileId.trim().equals("")) {
      asFile = null;
      this.setText("");
      this.setToolTipText(null);

      if (editable) {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(fileEditable);
      } else {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(false);
      }

      return;
    }
    asFile = new AsFile();
    asFile.setFileId(fileId);
    asFile.setFileName(fileName);

    this.setText(asFile.getFileName());
    this.setToolTipText(asFile.getFileName());

    if (editable) {
      deleteButton.setVisible(fileEditable);
      downloadButton.setVisible(fileEditable);
      uploadButton.setVisible(this.isDeleteOldFile);
      setButtonEnable();
    } else {
      deleteButton.setVisible(false);
      downloadButton.setVisible(true);
      uploadButton.setVisible(false);
    }
  }

  public void setFileId(final String fileId, final boolean editable) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        setFileId2(fileId, editable);
      }
    });
  }

  public void setFileId(final String fileId, final String fileName, final boolean editable) {
    setFileId3(fileId, fileName, editable);
  }

  private void saveFileToLocal(File defaultFile) {

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("�����ļ�");
    fileChooser.setApproveButtonText("����");
    fileChooser.setApproveButtonToolTipText("�����ļ�");
    fileChooser.setSelectedFile(defaultFile);//
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {

      File selectedFile = fileChooser.getSelectedFile();
      if (selectedFile.exists()) {
        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(this, selectedFile.getPath() + "�Ѿ�����\n��Ҫ����ԭʼ�ļ���", "��ʾ",
          JOptionPane.YES_NO_OPTION)) {
          saveFileToLocal(selectedFile);
          return;
        }
      }
      //      JOptionPane.showMessageDialog(this, fileChooser.getSelectedFile());
      FileOutputStream os = null;
      try {
        os = new FileOutputStream(fileChooser.getSelectedFile());
        os.write(asFile.getFileContent());
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        try {
          if (os != null) {
            os.close();
          }
        } catch (Exception e) {
          new RuntimeException(e.getMessage(), e);
        }
      }
      int yesNoResult = JOptionPane.showConfirmDialog(this, "�ļ��ѱ��ɹ����浽" + selectedFile.getPath() + "\n��Ҫ�򿪴��ļ���", "��ʾ", JOptionPane.YES_NO_OPTION);
      if (yesNoResult == JOptionPane.YES_OPTION) {
        try {
          Desktop.getDesktop().open(selectedFile);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "��Ǹ��û���ҵ����ʵĳ��������ļ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          return;
        }

      }

    }

  }

  private void doDownload() {
    try {
      asFile = baseDataServiceDelegate.downloadFile(asFile.getFileId(), requestMeta);

      File defaultFile = new File(defaultSavePath + asFile.getFileName());
      saveFileToLocal(defaultFile);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      JOptionPane.showMessageDialog(this, "�����ļ�ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void doDelete() {
    if (asFile != null && asFile.getFileId() != null) {
      try {
        baseDataServiceDelegate.deleteFile(asFile.getFileId(), requestMeta);
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(true);
        asFile = null;
        this.setText("");
        fireValueChanged();
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "ɾ���ļ�ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void doUpload() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setApproveButtonText("�ϴ�");
    fileChooser.setApproveButtonToolTipText("�ϴ���ѡ�ļ�");
    fileChooser.setDialogTitle("�ϴ��ļ�");
    fileChooser.setAcceptAllFileFilterUsed(isAllFileFilterUsed);
    if (this.fileExt != null && this.fileExt.length > 0) {
      for (String ext : this.fileExt) {
        if (ext != null && !"".equals(ext.trim())) {
          fileChooser.addChoosableFileFilter(new FileChooseFilter(ext.trim()));
        }
      }
    }

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();

      System.out.println("file.length() === " + file.length());
      FileInputStream fis = null;
      try {
        fis = new FileInputStream(file);
        BigDecimal available = new BigDecimal(fis.available());
        BigDecimal mByte = new BigDecimal(1024 * 1024);
        BigDecimal resultSize = available.divide(mByte, 2, BigDecimal.ROUND_HALF_UP);

        if (sizeLimit && resultSize.compareTo(maxSizeM) > 0) {
          JOptionPane.showMessageDialog(this, "�ļ�������" + maxSizeM + "m����,���ļ���������������ϴ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        this.absoluteFile = file.getAbsolutePath();
        if (this.isDeleteOldFile) {
          doDelete();
        }
        byte[] content = new byte[available.intValue()];
        //byte[] content = new byte[1024 * 1024 * 100];
        long startTime = System.currentTimeMillis();
        fis.read(content);
        System.out.println("client read file time === " + (System.currentTimeMillis() - startTime) / 1000f);
        asFile = new AsFile();
        asFile.setFileContent(content);
        asFile.setFileName(file.getName());
        asFile.setMimeType(MimeMapping.getMimeType(getExtension(file)));
        startTime = System.currentTimeMillis();
        String fileId = baseDataServiceDelegate.uploadFile(asFile, requestMeta);
        System.out.println("upload file to server time === " + (System.currentTimeMillis() - startTime) / 1000f);
        asFile.setFileId(fileId);
        setText(file.getName());
        setToolTipText(file.getPath());
        deleteButton.setVisible(true);
        downloadButton.setVisible(true);
        uploadButton.setVisible(this.isDeleteOldFile);
        setButtonEnable();

        fireValueChanged();

      } catch (Exception e) {
        e.printStackTrace();
        logger.error(e.getMessage(), e);
        JOptionPane.showMessageDialog(this, "�ϴ��ļ�ʧ�ܣ�\n" + e.getMessage(), "����", JOptionPane.ERROR_MESSAGE);
      } finally {
        if (fis != null) {
          try {
            fis.close();
          } catch (IOException e) {
            logger.error(e.getMessage(), e);
          }
        }
      }

    }
  }

  public String getFileId() {
    String fileId = null;
    if (asFile != null) {
      fileId = asFile.getFileId();
    }
    return fileId;
  }

  public String getFileName() {
    String fileName = null;
    if (asFile != null) {
      fileName = asFile.getFileName();
    }
    return fileName;
  }

  public AsFile getFile() {
    return asFile;
  }

  public static String getExtension(File f) {
    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(i + 1).toLowerCase();
    }
    return ext;
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public void removeValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList.getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }

  @Override
  public void setEditable(final boolean aFlag) {
    fileEditable = aFlag;

    if (uploadButton != null) {
      uploadButton.setVisible(aFlag);
    }
    if (deleteButton != null) {
      deleteButton.setVisible(aFlag);
    }
    if (downloadButton != null) {
      downloadButton.setVisible(aFlag);
    }
    if (aFlag) {
      setBackground(Color.WHITE);
    } else {
      setBackground(Color.GRAY);
    }
  }

  @Override
  public void setEnabled(boolean aFlag) {
    this.setEditable(aFlag);
  }

  public static void main(String[] args) {

    //    SwingUtilities.invokeLater(new Runnable() {
    //      public void run() {
    //        try {
    //          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    //          UIManager.setLookAndFeel(new GrayLookAndFeel());
    //        } catch (Exception e) {
    //          e.printStackTrace();
    //        }

    FileUploader fileField = new FileUploader();

    //        fileField.setFileId("0A0B104B000000000EC9AB6100000002");
    //        fileField.setEditable(false);
    UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
    JFrame frame = new JFrame("frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().add(fileField);

    frame.setVisible(true);
    //      }
    //    });

  }

  void setButtonEnable() {
    if (!this.isDelFileButton) {
      this.deleteButton.setEnabled(false);
      this.deleteButton.setVisible(false);
    }
    if (!this.isDownloadFileButton)
      this.downloadButton.setEnabled(false);
    if (!this.isUploadFileButton)
      this.uploadButton.setEnabled(false);

  }
}
