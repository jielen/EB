/**
 * EbConstant.java
 * com.ufgov.gk.client.component
 * Administrator
 * Sep 12, 2012
 */
package com.ufgov.gk.client.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author Administrator
 *
 */
public class EbConstant {

  public static final Integer INTEGER0 = new Integer(0);

  public static final Integer INTEGER1 = new Integer(1);

  public static final Integer INTEGER2 = new Integer(2);

  public static final Integer INTEGER3 = new Integer(3);

  public static final Integer INTEGER4 = new Integer(4);

  public static final Integer INTEGER5 = new Integer(5);

  public static final Double DOUBLE0 = new Double(0.0D);

  public static final Double DOUBLE1 = new Double(1.0D);

  public static final int DIAL_HAND_STYLE_LINE = 1;

  public static final int DIAL_HAND_STYLE_TRIANGLE = 2;

  public static final int DIAL_HAND_STYLE_ARROW = 3;

  public static final int DIAL_SCALE_STYLE_LINE = 1;

  public static final int DIAL_SCALE_STYLE_BALL = 2;

  public static final int DIAL_TYPE_WHOLE = 1;

  public static final int DIAL_TYPE_ARC = 2;

  public static final int RADAE_RING_STYLE_LINE = 1;

  public static final int RADAE_RING_STYLE_ELLIPSE = 2;

  public static final int BAR_TYPE_DEFAULT = 1;

  public static final int BAR_TYPE_GROUP = 2;

  public static final int BAR_TYPE_STACK = 3;

  public static final int BAR_TYPE_LAYER = 4;

  public static final int BAR_TYPE_PERCENT = 5;

  public static final int LINE_TYPE_DEFAULT = 1;

  public static final int LINE_TYPE_AREA = 2;

  public static final int LINE_TYPE_POLE = 3;

  public static final int PERCENT_STYLE_PLANE = 1;

  public static final int PERCENT_STYLE_SOLID = 2;

  public static final int PERCENT_STYLE_SEGMENT = 3;

  public static final int PERCENT_MARKER_START_WITH_EDGE = 1;

  public static final int PERCENT_MARKER_START_WITH_BOTTOM = 2;

  public static final int PERCENT_TYPE_HORIZONTAL = 1;

  public static final int PERCENT_TYPE_VERTICAL = 2;

  public static final int PERCENT_MARKER_POSITION_DEFAULT = 1;

  public static final int PERCENT_MARKER_POSITION_INNER_DEFAULT = 10;

  public static final int PERCENT_MARKER_POSITION_TOP = 2;

  public static final int PERCENT_MARKER_POSITION_INNER_TOP = 3;

  public static final int PERCENT_MARKER_POSITION_BOTTOM = 4;

  public static final int PERCENT_MARKER_POSITION_INNER_BOTTOM = 5;

  public static final int PERCENT_MARKER_POSITION_LEFT = 6;

  public static final int PERCENT_MARKER_POSITION_INNER_LEFT = 7;

  public static final int PERCENT_MARKER_POSITION_RIGHT = 8;

  public static final int PERCENT_MARKER_POSITION_INNER_RIGHT = 9;

  public static final int MARKER_SHAPE_NONE = 0;

  public static final int MARKER_SHAPE_LINE = 1;

  public static final int MARKER_SHAPE_TRIANGLE = 2;

  public static final int INFLEXION_STYLE_CIRCLE = 1;

  public static final int INFLEXION_STYLE_DIAMOND = 2;

  public static final int INFLEXION_STYLE_RECTANGLE = 3;

  public static final int INFLEXION_STYLE_TRIANGLE = 4;

  public static final int JOINT_POINT_NEAR = 1;

  public static final int JOINT_POINT_NORTH = 2;

  public static final int JOINT_POINT_SOUTH = 3;

  public static final int JOINT_POINT_WEST = 4;

  public static final int JOINT_POINT_EAST = 5;

  public static final int BORDER_TYPE_DEFAULT = 1;

  public static final int BORDER_TYPE_POINT = 2;

  public static final int BORDER_TYPE_SHAPE = 3;

  public static final int UNCHECKABLE_STYLE_NONE = 1;

  public static final int UNCHECKABLE_STYLE_BLANK = 2;

  public static final int UNCHECKABLE_STYLE_DISABLE = 3;

  public static final int LEGEND_LAYOUT_HORIZONTAL = 1;

  public static final int LEGEND_LAYOUT_VERTICAL = 2;

  public static final int LEGEND_LAYOUT_HORIZONTAL_WEST = 3;

  public static final int LEGEND_LAYOUT_HORIZONTAL_EAST = 4;

  public static final int LEGEND_LAYOUT_HORIZONTAL_NORTH = 5;

  public static final int LEGEND_LAYOUT_HORIZONTAL_SOUTH = 6;

  public static final int LEGEND_LAYOUT_VERTICAL_WEST = 7;

  public static final int LEGEND_LAYOUT_VERTICAL_EAST = 8;

  public static final int LEGEND_LAYOUT_VERTICAL_NORTH = 9;

  public static final int LEGEND_LAYOUT_VERTICAL_SOUTH = 10;

  public static final int LINK_TYPE_PARALLEL = 0;

  public static final int LINK_TYPE_STRAIGHT = 1;

  public static final int LINK_TYPE_FLEXIONAL = 2;

  public static final int LINK_TYPE_ORTHOGONAL = 3;

  public static final int LINK_TYPE_CURVOUS = 4;

  public static final int LINK_TYPE_ZIGZAG = 5;

  public static final int LINK_TYPE_XSPLIT = 6;

  public static final int LINK_TYPE_YSPLIT = 7;

  public static final int LINK_TYPE_TOP = 8;

  public static final int LINK_TYPE_BOTTOM = 9;

  public static final int LINK_TYPE_LEFT = 10;

  public static final int LINK_TYPE_RIGHT = 11;

  public static final String LINK_STYLE_SOLID = "solid";

  public static final String LINK_STYLE_DASH = "dash";

  public static final String LINK_STYLE_CHAIN = "chain";

  public static final String LINK_STYLE_DOT = "dot";

  public static final String LINK_STYLE_ZIGZAG = "zigzag";

  public static final String LINK_STYLE_BROKEN = "broken";

  public static final int SHAPELINK_STRAIGHT_LINE = 1;

  public static final int SHAPELINK_QUADRATIC_CURVE = 2;

  public static final int SHAPELINK_BEZIER_CURVE = 3;

  public static final int SHAPELINK_ORTHOGONAL_LINE = 4;

  public static final int SHAPENODE_NONE = 0;

  public static final int SHAPENODE_STRAIGHT_LINE = 1;

  public static final int SHAPENODE_CLOSE_STRAIGHT_LINE = 2;

  public static final int SHAPENODE_QUADRATIC_CURVE = 3;

  public static final int SHAPENODE_CLOSE_QUADRATIC_CURVE = 4;

  public static final int SHAPENODE_BEZIER_CURVE = 5;

  public static final int SHAPENODE_CLOSE_BEZIER_CURVE = 6;

  public static final int SHAPENODE_ORTHOGONAL_LINE = 7;

  public static final int SHAPENODE_ELLIPSE = 8;

  public static final int SHAPENODE_ROUND = 9;

  public static final int ATTACHMENT_STYLE_DEFAULT = 1;

  public static final int ATTACHMENT_STYLE_BUBBLE = 2;

  public static final int MESSAGE_COMPONENT_LABEL = 1;

  public static final int MESSAGE_COMPONENT_TEXTPANE = 2;

  public static final int ATTACHMENT_DIRECTION_TOP_LEFT = 1;

  public static final int ATTACHMENT_DIRECTION_TOP_RIGHT = 2;

  public static final int ATTACHMENT_DIRECTION_BOTTOM_LEFT = 3;

  public static final int ATTACHMENT_DIRECTION_BOTTOM_RIGHT = 4;

  public static final int ATTACHMENT_DIRECTION_LEFT_TOP = 5;

  public static final int ATTACHMENT_DIRECTION_LEFT_BOTTOM = 6;

  public static final int ATTACHMENT_DIRECTION_RIGHT_TOP = 7;

  public static final int ATTACHMENT_DIRECTION_RIGHT_BOTTOM = 8;

  public static final int ATTACHMENT_DIRECTION_TOP = 9;

  public static final int ATTACHMENT_DIRECTION_BOTTOM = 10;

  public static final int ATTACHMENT_DIRECTION_LEFT = 11;

  public static final int ATTACHMENT_DIRECTION_RIGHT = 12;

  public static final String ATTACHMENT_LINK_CNET = "attachment.link.cnet";

  public static final String ATTACHMENT_LINK_ELECTRICAL = "attachment.link.electrical";

  public static final String ATTACHMENT_LINK_FIBER = "attachment.link.fiber";

  public static final String ATTACHMENT_MESSAGE = "attachment.message";

  public static final String TEXTURE_STIPPLE_LOOSE = "stipple.loose";

  public static final String TEXTURE_STIPPLE_MIDDLE = "stipple.middle";

  public static final String TEXTURE_STIPPLE_DENSE = "stipple.dense";

  public static final String TEXTURE_GRID_DIAMOND = "grid.diamond";

  public static final String TEXTURE_GRID_SQUARE = "grid.square";

  public static final String TEXTURE_GRID_TRIANGLE = "grid.triangle";

  public static final String TEXTURE_LINE_CROSS = "line.cross";

  public static final String TEXTURE_LINE_VERTICAL = "line.vertical";

  public static final String TEXTURE_LINE_HORIZONTAL = "line.horizontal";

  public static final String TEXTURE_LINE_DIAGONAL = "line.diagonal";

  public static final String TEXTURE_LINE_ANTIDIAGONAL = "line.antidiagonal";

  public static final int TRISTATE_SELECTED = 1;

  public static final int TRISTATE_DESELECTED = 2;

  public static final int TRISTATE_NOTSPECIFIED = 3;

  public static final int FONT_STYLE_DEFAULT = 1;

  public static final int FONT_STYLE_PLAIN = 2;

  public static final int FONT_STYLE_BOLD = 3;

  public static final int FONT_STYLE_ITALIC = 4;

  public static final int FONT_STYLE_ITALIC_BOLD = 5;

  public static final int GROUP_TYPE_RECTANGLE = 1;

  public static final int GROUP_TYPE_ELLIPSE = 2;

  public static final int GROUP_TYPE_PARALLELOGRAM = 3;

  public static final int GROUP_TYPE_ROUND = 4;

  public static final int GROUP_TYPE_ROUND_RECTANGLE = 5;

  public static final int GROUP_TYPE_OCTAGON = 6;

  public static final int LAYOUT_CIRCULAR = 1;

  public static final int LAYOUT_TREE = 2;

  public static final int LAYOUT_REVERSETREE = 3;

  public static final int LAYOUT_SYMMETRIC = 4;

  public static final int LAYOUT_EAST = 5;

  public static final int LAYOUT_WEST = 6;

  public static final int LAYOUT_HIERARCHIC = 7;

  public static final int ANTENNA_TYPE_SECTOR = 1;

  public static final int ANTENNA_TYPE_ELLIPSE = 2;

  public static final int ANTENNA_TYPE_TRIANGLE = 3;

  public static final int ANTENNA_TYPE_RECTANGLE = 4;

  public static final int ANTENNA_TYPE_ROUND_RECTANGLE = 5;

  public static final int POSITION_HOTSPOT = 0;

  public static final int POSITION_CENTER = 1;

  public static final int POSITION_TOP = 2;

  public static final int POSITION_BOTTOM = 3;

  public static final int POSITION_LEFT = 4;

  public static final int POSITION_RIGHT = 5;

  public static final int POSITION_TOPLEFT = 6;

  public static final int POSITION_TOPRIGHT = 7;

  public static final int POSITION_BOTTOMLEFT = 8;

  public static final int POSITION_BOTTOMRIGHT = 9;

  public static final int POSITION_INNER_BOTTOM = 10;

  public static final int POSITION_INNER_TOP = 11;

  public static final int POSITION_INNER_LEFT = 12;

  public static final int POSITION_INNER_RIGHT = 13;

  public static final int POSITION_INNER_TOPLEFT = 14;

  public static final int POSITION_INNER_TOPRIGHT = 15;

  public static final int POSITION_INNER_BOTTOMLEFT = 16;

  public static final int POSITION_INNER_BOTTOMRIGHT = 17;

  public static final int POSITION_LINK_FROM_ANCHOR = 18;

  public static final int POSITION_LINK_TO_ANCHOR = 19;

  public static final int LABEL_ORIENTATION_HORIZONTAL = 1;

  public static final int LABEL_ORIENTATION_VERTICAL = 2;

  public static final int LABEL_ORIENTATION_LEFT = 3;

  public static final int LABEL_ORIENTATION_RIGHT = 4;

  public static final int ORIENTATION_NORTH = 1;

  public static final int ORIENTATION_NORTH_EAST = 2;

  public static final int ORIENTATION_EAST = 3;

  public static final int ORIENTATION_SOUTH_EAST = 4;

  public static final int ORIENTATION_SOUTH = 5;

  public static final int ORIENTATION_SOUTH_WEST = 6;

  public static final int ORIENTATION_WEST = 7;

  public static final int ORIENTATION_NORTH_WEST = 8;

  public static final int ARROW_STANDARD_SMALL = 1;

  public static final int ARROW_STANDARD = 2;

  public static final int ARROW_STANDARD_GREAT = 3;

  public static final int ARROW_DELTA_SMALL = 4;

  public static final int ARROW_DELTA = 5;

  public static final int ARROW_DELTA_GREAT = 6;

  public static final int ARROW_DIAMOND_SMALL = 7;

  public static final int ARROW_DIAMOND = 8;

  public static final int ARROW_DIAMOND_GREAT = 9;

  public static final int ARROW_SHORT_SMALL = 10;

  public static final int ARROW_SHORT = 11;

  public static final int ARROW_SHORT_GREAT = 12;

  public static final int ARROW_CIRCLE_SMALL = 13;

  public static final int ARROW_CIRCLE = 14;

  public static final int ARROW_CIRCLE_GREAT = 15;

  public static final int ARROW_STAR_SMALL = 16;

  public static final int ARROW_STAR = 17;

  public static final int ARROW_STAR_GREAT = 18;

  public static final int ARROW_RECTANGLE_SMALL = 19;

  public static final int ARROW_RECTANGLE = 20;

  public static final int ARROW_RECTANGLE_GREAT = 21;

  public static final int MOUSE_LEFT_CLICKED = 1;

  public static final int MOUSE_LEFT_DOUBLE_CLICKED = 2;

  public static final int MOUSE_RIGHT_CLICKED = 3;

  public static final int MOUSE_RIGHT_DOUBLE_CLICKED = 4;

  public static final String DEFAULT_ENCODING = "UTF-8";

  public static final Locale EN_US = new Locale("en", "US");

  public static final Locale ZH_CN = new Locale("zh", "CN");

  public static final Locale ZH_TW = new Locale("zh", "TW");

  public static final Locale JA_JP = new Locale("ja", "JP");

  public static final Locale ES_ES = new Locale("es", "ES");

  public static final String CLIENT_PROPERTY_GETTER_NAME = "getClientProperty";

  public static final String CLIENT_PROPERTY_SETTER_NAME = "putClientProperty";

  public static final String USER_PROPERTY_GETTER_NAME = "getUserProperty";

  public static final String USER_PROPERTY_SETTER_NAME = "putUserProperty";

  public static final Class[] CLIENT_PROPERTY_GETTER_METHOD_PARAM = { Object.class };

  public static final Class[] CLIENT_PROPERTY_SETTER_METHOD_PARAM = { Object.class, Object.class };

  public static final Class[] EMPTY_PARAM_CLASS = new Class[0];

  public static final Object[] EMPTY_PARAM_VALUE = new Object[0];

  public static final Point ORIGIN_POINT = new Point(0, 0);

  public static final Rectangle EMPTY_BOUNDS = new Rectangle();

  public static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();

  public static final Dimension EMPTY_DIMENSION = new Dimension(0, 0);

  public static final Insets NONE_INSETS = new Insets(0, 0, 0, 0);

  public static final Insets THIN_INSETS = new Insets(1, 1, 1, 1);

  public static final NumberFormat DEFAULT_INT_FORMATER = NumberFormat.getInstance();

  public static final NumberFormat DEFAULT_DOUBLE_FORMATER;

  public static final String BLANK_IMAGE = "-";

  public static final List EMPTY_LIST;

  public static final int DEFAULT_ELEMENT_WIDTH = 40;

  public static final int DEFAULT_ELEMENT_HEIGHT = 40;

  public static AffineTransform BASIC_TRANSFORM;

  public static final Stroke THINNEST_STROKE;

  public static final Stroke BASIC_STROKE;

  public static final Color COLOR_GRAY;

  public static final Color COLOR_IVORY;

  public static final Color COLOR_SHADOW;

  public static final Color COLOR_DRAKERCYAN;

  public static final Color COLOR_DARK;

  public static final String BOJP_PREFIX = "BOJP:";

  public static final String BOCP_PREFIX = "BOCP:";

  public static final String USER_PROPERTY_PREFIX = "UP:";

  public static final String CLIENT_PROPERTY_PREFIX = "CP:";

  public static final String ELEMENT_UPDATE_UI = "element.update.ui";

  public static final String DATABOX = "databox";

  public static final String LOCKED = "locked";

  public static final String ALARMSTATE = "alarmstate";

  public static final String CLASS_NAME_PREFIX = "className:";

  public static final String GIF_PREFIX = "gif:";

  public static final String I18N_KEY_PREFIX = "i18nKey:";

  public static final String ELEMENT_STATE_ICON_PREFIX = "StateIcon:";

  public static final String TOOLBAR_SEPARATOR_ID = "$SEPARATOR";

  public static final String TERMINATE_EDIT_ON_FOCUS_LOST = "terminateEditOnFocusLost";

  public static final String JINTERNALFRAME_ISPALETTE = "JInternalFrame.isPalette";

  public static final Color DND_TARGET_COLOR;

  public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

  public static final BasicStroke DASHED_STROKE;

  public static final Stroke DOUBLE_WIDTH_STROKE;

  public static final String STROKE_SOLID_THINNEST = "solid.thinnest";

  public static final String STROKE_SOLID_THIN = "solid.thin";

  public static final String STROKE_SOLID_MIDDLE = "solid.middle";

  public static final String STROKE_SOLID_THICK = "solid.thick";

  public static final String STROKE_SOLID_THICKEST = "solid.thickest";

  public static final String STROKE_DOT_THINNEST = "dot.thinnest";

  public static final String STROKE_DOT_THIN = "dot.thin";

  public static final String STROKE_DOT_MIDDLE = "dot.middle";

  public static final String STROKE_DOT_THICK = "dot.thick";

  public static final String STROKE_DOT_THICKEST = "dot.thickest";

  public static final String STROKE_SQUARE_THINNEST = "square.thinnest";

  public static final String STROKE_SQUARE_THIN = "square.thin";

  public static final String STROKE_SQUARE_MIDDLE = "square.middle";

  public static final String STROKE_SQUARE_THICK = "square.thick";

  public static final String STROKE_SQUARE_THICKEST = "square.thickest";

  public static final String STROKE_DASH_THINNEST = "dash.thinnest";

  public static final String STROKE_DASH_THIN = "dash.thin";

  public static final String STROKE_DASH_MIDDLE = "dash.middle";

  public static final String STROKE_DASH_THICK = "dash.thick";

  public static final String STROKE_DASH_THICKEST = "dash.thickest";

  public static final String STROKE_DASH_DOT_THINNEST = "dash.dot.thinnest";

  public static final String STROKE_DASH_DOT_THIN = "dash.dot.thin";

  public static final String STROKE_DASH_DOT_MIDDLE = "dash.dot.middle";

  public static final String STROKE_DASH_DOT_THICK = "dash.dot.thick";

  public static final String STROKE_DASH_DOT_THICKEST = "dash.dot.thickest";

  public static final String STROKE_DASH_DOT_DOT_THINNEST = "dash.dot.dot.thinnest";

  public static final String STROKE_DASH_DOT_DOT_THIN = "dash.dot.dot.thin";

  public static final String STROKE_DASH_DOT_DOT_MIDDLE = "dash.dot.dot.middle";

  public static final String STROKE_DASH_DOT_DOT_THICK = "dash.dot.dot.thick";

  public static final String STROKE_DASH_DOT_DOT_THICKEST = "dash.dot.dot.thickest";

  public static final String STROKE_ZIGZAG_NARROWEST = "zigzag.narrowest";

  public static final String STROKE_ZIGZAG_NARROW = "zigzag.narrow";

  public static final String STROKE_ZIGZAG_MIDDLE = "zigzag.middle";

  public static final String STROKE_ZIGZAG_WIDE = "zigzag.wide";

  public static final String STROKE_ZIGZAG_WIDEST = "zigzag.widest";

  public static final String STROKE_SOLID_0 = "solid.0";

  public static final String STROKE_SOLID_1 = "solid.1";

  public static final String STROKE_SOLID_2 = "solid.2";

  public static final String STROKE_SOLID_3 = "solid.3";

  public static final String STROKE_SOLID_4 = "solid.4";

  public static final String STROKE_SOLID_5 = "solid.5";

  public static final String STROKE_SOLID_6 = "solid.6";

  public static final String STROKE_SOLID_7 = "solid.7";

  public static final String STROKE_SOLID_8 = "solid.8";

  public static final String STROKE_SOLID_9 = "solid.9";

  public static final String STROKE_SOLID_10 = "solid.10";

  public static final String STROKE_SOLID_11 = "solid.11";

  public static final String STROKE_SOLID_12 = "solid.12";

  public static final String STROKE_SOLID_13 = "solid.13";

  public static final String STROKE_SOLID_14 = "solid.14";

  public static final String STROKE_SOLID_15 = "solid.15";

  public static final String STROKE_SOLID_16 = "solid.16";

  public static final String STROKE_SOLID_17 = "solid.17";

  public static final String STROKE_SOLID_18 = "solid.18";

  public static final String STROKE_SOLID_19 = "solid.19";

  public static final String STROKE_SOLID_20 = "solid.20";

  public static final int SHAPE_CIRCLE = 1;

  public static final int SHAPE_RECTANGLE = 2;

  public static final int SHAPE_ROUND_RECTANGLE = 3;

  public static final int SHAPE_ROUND_RECTANGLE_HALF = 4;

  public static final int SHAPE_ROUND_RECTANGLE_QUARTER = 5;

  public static final int SHAPE_ROUND_VAULT = 6;

  public static final int SHAPE_ROUND_VAULT_HALF = 7;

  public static final int SHAPE_ROUND_VAULT_QUARTER = 8;

  public static final int SHAPE_DIAMOND = 9;

  public static final int SHAPE_TRIANGLE = 10;

  public static final int SHAPE_STAR = 11;

  public static final int SHAPE_ROUND = 12;

  public static final int SHAPE_ARROW_LEFT = 13;

  public static final int SHAPE_ARROW_RIGHT = 14;

  public static final int SHAPE_ARROW_ABOVE = 15;

  public static final int SHAPE_ARROW_BELOW = 16;

  public static final int SHAPE_TAIL_LEFT = 17;

  public static final int SHAPE_TAIL_RIGHT = 18;

  public static final int SHAPE_TAIL_ABOVE = 19;

  public static final int SHAPE_TAIL_BELOW = 20;

  public static final int SHAPE_CARD_LEFT = 21;

  public static final int SHAPE_CARD_RIGHT = 22;

  public static final int SHAPE_WAVE_LEFT = 23;

  public static final int SHAPE_WAVE_RIGHT = 24;

  public static final int GRADIENT_LINE_SW = 1;

  public static final int GRADIENT_LINE_SE = 2;

  public static final int GRADIENT_LINE_NW = 3;

  public static final int GRADIENT_LINE_NE = 4;

  public static final int GRADIENT_LINE_N = 5;

  public static final int GRADIENT_LINE_S = 6;

  public static final int GRADIENT_LINE_W = 7;

  public static final int GRADIENT_LINE_E = 8;

  public static final int GRADIENT_RADIAL_C = 10;

  public static final int GRADIENT_RADIAL_SW = 11;

  public static final int GRADIENT_RADIAL_SE = 12;

  public static final int GRADIENT_RADIAL_NW = 13;

  public static final int GRADIENT_RADIAL_NE = 14;

  public static final int GRADIENT_RADIAL_N = 15;

  public static final int GRADIENT_RADIAL_S = 16;

  public static final int GRADIENT_RADIAL_W = 17;

  public static final int GRADIENT_RADIAL_E = 18;

  public static final int GRADIENT_EXTEND_HORIZONTAL = 19;

  public static final int GRADIENT_EXTEND_VERTICAL = 20;

  public static final int GRADIENT_EXTEND_DIAGONAL = 21;

  public static final int GRADIENT_EXTEND_ANTIDIAGONAL = 22;

  public static final int GRADIENT_EXTEND_N = 23;

  public static final int GRADIENT_EXTEND_S = 24;

  public static final int GRADIENT_EXTEND_W = 25;

  public static final int GRADIENT_EXTEND_E = 26;

  public static final String ENUM_INFLEXION_STYLE = "twaver.inflexion.style";

  public static final String ENUM_JOINT_POINT = "twaver.joint.point";

  public static final String ENUM_ALARM_SEVERITY = "twaver.alarm.severity";

  public static final String ENUM_DIRECTION = "twaver.direction";

  public static final String ENUM_BORDER_TYPE = "twaver.border.type";

  public static final String ENUM_ATTACHMENT_DIRECTION = "twaver.attachment.direction";

  public static final String ENUM_ATTACHMENT_STYLE = "twaver.attachment.style";

  public static final String ENUM_MESSAGE_COMPONENT = "twaver.message.component";

  public static final String ENUM_LEGEND_LAYOUT = "twaver.legend.layout";

  public static final String ENUM_ORIENTATION = "twaver.orientation";

  public static final String ENUM_POSITION = "twaver.position";

  public static final String ENUM_LABEL_ORIENTATION = "twaver.label.orientation";

  public static final String ENUM_SHAPE = "twaver.shape";

  public static final String ENUM_GRADIENT = "twaver.gradient";

  public static final String ENUM_ORTHOGONAL = "twaver.orthogonal";

  public static final String ENUM_GROUPTYPE = "twaver.grouptype";

  public static final String ENUM_SHAPELINKTYPE = "twaver.shapelinktype";

  public static final String ENUM_SHAPENODETYPE = "twaver.shapenodetype";

  public static final String ENUM_ANTENNATYPE = "twaver.antennatype";

  public static final String ENUM_LINKTYPE = "twaver.linktype";

  public static final String ENUM_ARROWSTYLE = "twaver.arrowstyle";

  public static final String TOOLBAR_BUTTON_GROUP_KEY_PREFIX = "buttonGroup:";

  public static final String BUTTON_GROUP_NAME_KEY = "buttonGroupName";

  public static final String DEFAULT_BUTTON_GROUP_NAME = "default";

  public static final String SIMPLE_TOOLBAR = "simple";

  public static final String DEFAULT_TOOLBAR = "default";

  public static final String EDITOR_TOOLBAR = "editor";

  public static final String TOOLBAR_SELECTION = "Selection";

  public static final String TOOLBAR_LAZYMOVE = "LazyMove";

  public static final String TOOLBAR_PAN = "Pan";

  public static final String TOOLBAR_MAGNIFIER = "Magnifier";

  public static final String TOOLBAR_UP = "Up";

  public static final String TOOLBAR_ZOOMIN = "ZoomIn";

  public static final String TOOLBAR_ZOOMOUT = "ZoomOut";

  public static final String TOOLBAR_ZOOMBACK = "ZoomBack";

  public static final String TOOLBAR_ZOOMRESET = "ZoomReset";

  public static final String TOOLBAR_ZOOMTOOVERVIEW = "ZoomToOverview";

  public static final String TOOLBAR_ZOOMTORECTANGLE = "ZoomToRectangle";

  public static final String TOOLBAR_OVERVIEW = "Overview";

  public static final String TOOLBAR_FULLSCREEN = "FullScreen";

  public static final String TOOLBAR_OPENDATAFILE = "OpenDataFile";

  public static final String TOOLBAR_SAVEDATAFILE = "SaveDataFile";

  public static final String TOOLBAR_EXPORTIMAGE = "ExportImage";

  public static final String TOOLBAR_EXPORTSVG = "ExportSVG";

  public static final String TOOLBAR_PRINT = "Print";

  public static final String TOOLBAR_UNDO = "Undo";

  public static final String TOOLBAR_REDO = "Redo";

  public static final String TOOLBAR_PRINTPREVIEW = "PrintPreview";

  public static final String TOOLBAR_CREATENODE = "CreateNode";

  public static final String TOOLBAR_CREATETEXT = "CreateText";

  public static final String TOOLBAR_CREATELINK = "CreateLink";

  public static final String TOOLBAR_CREATEFLEXIONLINK = "CreateFlexionLink";

  public static final String TOOLBAR_CREATEORTHOGONALLINK = "CreateOrthogonalLink";

  public static final String TOOLBAR_CREATESHAPELINK = "CreateShapeLink";

  public static final String TOOLBAR_CREATELINKSUBNETWORK = "CreateLinkSubNetwork";

  public static final String TOOLBAR_CREATEPOLY = "CreatePoly";

  public static final String TOOLBAR_CREATESHAPENODE = "CreateShapeNode";

  public static final String TOOLBAR_CREATESHAPESUBNETWORK = "CreateShapeSubNetwork";

  public static final String TOOLBAR_ICON_SELECT = "toolbar.icon.select";

  public static final String TOOLBAR_ICON_LAZYMOVE = "toolbar.icon.lazymove";

  public static final String TOOLBAR_ICON_PAN = "toolbar.icon.pan";

  public static final String TOOLBAR_ICON_MAGNIFIER = "toolbar.icon.magnifier";

  public static final String TOOLBAR_ICON_UP = "toolbar.icon.up";

  public static final String TOOLBAR_ICON_ZOOMIN = "toolbar.icon.zoomin";

  public static final String TOOLBAR_ICON_ZOOMOUT = "toolbar.icon.zoomout";

  public static final String TOOLBAR_ICON_ZOOMBACK = "toolbar.icon.zoomback";

  public static final String TOOLBAR_ICON_ZOOMRESET = "toolbar.icon.zoomreset";

  public static final String TOOLBAR_ICON_ZOOMTOOVERVIEW = "toolbar.icon.zoomtooverview";

  public static final String TOOLBAR_ICON_ZOOMTORECTANGLE = "toolbar.icon.zoomtorectangle";

  public static final String TOOLBAR_ICON_OVERVIEW = "toolbar.icon.overview";

  public static final String TOOLBAR_ICON_FULLSCREEN = "toolbar.icon.fullscreen";

  public static final String TOOLBAR_ICON_OPENDATAFILE = "toolbar.icon.opendatafile";

  public static final String TOOLBAR_ICON_SAVEDATAFILE = "toolbar.icon.savedatafile";

  public static final String TOOLBAR_ICON_EXPORTIMAGE = "toolbar.icon.exportimage";

  public static final String TOOLBAR_ICON_EXPORTSVG = "toolbar.icon.exportsvg";

  public static final String TOOLBAR_ICON_PRINT = "toolbar.icon.print";

  public static final String TOOLBAR_ICON_UNDO = "toolbar.icon.undo";

  public static final String TOOLBAR_ICON_REDO = "toolbar.icon.redo";

  public static final String TOOLBAR_ICON_PRINTPREVIEW = "toolbar.icon.printpreview";

  public static final String TOOLBAR_ICON_CREATENODE = "toolbar.icon.createnode";

  public static final String TOOLBAR_ICON_CREATETEXT = "toolbar.icon.createtext";

  public static final String TOOLBAR_ICON_CREATELINK = "toolbar.icon.createlink";

  public static final String TOOLBAR_ICON_CREATEFLEXIONLINK = "toolbar.icon.createflexionlink";

  public static final String TOOLBAR_ICON_CREATEORTHOGONALLINK = "toolbar.icon.createorthogonallink";

  public static final String TOOLBAR_ICON_CREATESHAPELINK = "toolbar.icon.createshapelink";

  public static final String TOOLBAR_ICON_CREATELINKSUBNETWORK = "toolbar.icon.createlinksubnetwork";

  public static final String TOOLBAR_ICON_CREATEPOLY = "toolbar.icon.createpoly";

  public static final String TOOLBAR_ICON_CREATESHAPENODE = "toolbar.icon.createshapenode";

  public static final String TOOLBAR_ICON_CREATESHAPESUBNETWORK = "toolbar.icon.createshapesubnetwork";

  public static final String WEB_ID_PREFIX_IMAGE = "web.id.prefix.image";

  public static final String WEB_ID_PREFIX_DEFINITION = "web.id.prefix.definition";

  public static final String WEB_ID_PREFIX_GRADIENT = "web.id.prefix.gradient";

  public static final String WEB_ID_PREFIX_TEXTURE = "web.id.prefix.texture";

  public static final String WEB_SVG_XMLNS = "web.svg.xmlns";

  public static final String WEB_SVG_ENABLE_ZOOMANDPAN = "web.svg.enable.zoomandpan";

  public static final String WEB_SVG_USE_BASE64 = "web.svg.use.base64";

  public static final String WEB_SVG_SHOW_ALARM_ON_TOP = "web.svg.show.alarm.on.top";

  public static final String WEB_SVG_USE_CDATA = "web.svg.use.cdata";

  public static final String WEB_SVG_TEXT_ESCAPE = "web.svg.text.escape";

  public static final String WEB_DEFAULT_BACKGROUND_COLOR = "web.default.background.color";

  public static final String WEB_PHYSICAL_PATH = "web.physical.path";

  public static final String WEB_IMAGE_FILE_PATH = "web.image.file.path";

  public static final String WEB_PROJECT_NAME = "web.project.name";

  public static final String WEB_IMAGE_URL_PREFIX = "web.image.url.prefix";

  public static final String WEB_IMAGE_CACHE = "web.image.cache";

  public static final String WEB_IMAGE_FORMAT = "web.image.format";

  public static final String WEB_MIN_BACKGROUND_SIZE = "web.min.background.size";

  public static final String DEFAULT_SVG_CHART_SIZE = "web.default.chart.size";

  public static final String WEB_COMPONENT_ATTACHMENT_MINIMIZEDICON_URL = "web.component.attachment.minimizedicon.url";

  public static final String WEB_PATH_DISTANCE = "web.path.distance";

  public static final String WEB_PATH_NUMBERFROMAT = "web.path.numberformat";

  public static final String TABLE_ALIGNMENT_ALARMSEVERITY = "table.alignment.alarmseverity";

  public static final String TABLE_ALIGNMENT_STRING = "table.alignment.string";

  public static final String TABLE_ALIGNMENT_NUMBER = "table.alignment.number";

  public static final String TABLE_ALIGNMENT_ENUMTYPE = "table.alignment.enumtype";

  public static final String TABLE_ALIGNMENT_BOOLEAN = "table.alignment.boolean";

  public static final String TABLE_ALIGNMENT_DATE = "table.alignment.date";

  public static final String TABLE_ALIGNMENT_COLOR = "table.alignment.color";

  public static final String TABLE_ALIGNMENT_FONT = "table.alignment.font";

  public static final String TABLE_ALIGNMENT_ICON = "table.alignment.icon";

  public static final String TABLE_ALIGNMENT_ELEMENT = "table.alignment.element";

  public static final String ALARM_TABLE_LAZY_PUBLISH_MODE = "alarm.table.lazy.publish.mode";

  public static final String TABLE_LAZY_PUBLISH_MODE = "table.lazy.publish.mode";

  public static final String TABLE_SHOW_TABLE_HEADER_ICON = "table.show.table.header.icon";

  public static final String TABLE_SORTABLE = "table.sortable";

  public static final String TABLE_LOCAL_SORTABLE = "table.local.sortable";

  public static final String TABLE_MULTI_COLUMN_SORTABLE = "table.multi.column.sortable";

  public static final String TABLE_SELECTABLE_ON_RIGHT_CLICK = "table.selectable.on.right.click";

  public static final String TABLE_CLEAR_SELECTION_ON_MARGIN_CLICKED = "table.clear.selection.on.margin.clicked";

  public static final String TABLE_SHOW_PREDEFINED_COLUMNS_IN_POPUPMENU = "table.show.predefined.columns.in.popupmenu";

  public static final String TABLE_ENABLE_TRISTATE_SORTING = "table.enable.tristate.sorting";

  public static final String TABLE_CONVERSE_INCREASE_ORDER = "table.converse.increase.order";

  public static final String TABLE_ENSURE_VISIBLE_ON_SELECTED = "table.ensure.visible.on.selected";

  public static final String TABLE_TREE_COLUMN_MOVABLE = "table.tree.column.movable";

  public static final String TABLE_DISTINCT_SORTABLE_HEADER = "table.distinct.sortable.header";

  public static final String TABLE_ENABLE_RIGHT_CLICK_EVENT = "table.enable.right.click.event";

  public static final String TREE_ENABLE_RIGHT_CLICK_EVENT = "tree.enable.right.click.event";

  public static final String TREE_ENABLE_DND = "tree.enable.dnd";

  public static final String TREE_ICON_WIDTH = "tree.icon.width";

  public static final String TREE_ICON_HEIGHT = "tree.icon.height";

  public static final String TREE_EXPANDED_ICON = "tree.expanded.icon";

  public static final String TREE_COLLAPSED_ICON = "tree.collapsed.icon";

  public static final String TREE_SELECTION_MODE = "tree.selection.mode";

  public static final String TREE_UNCHECKABLE_STYLE = "tree.uncheckable.style";

  public static final String TREE_DATABOX_NODE_ICON = "tree.databox.node.icon";

  public static final String TREE_DATABOX_LABEL_EDITABLE = "tree.databox.label.editable";

  public static final String TREE_ICON_VISIBLE = "tree.icon.visible";

  public static final String TREE_SELECTABLE_ON_RIGHT_CLICK = "tree.selectable.on.right.click";

  public static final String TREE_CLEAR_SELECTION_ON_MARGIN_CLICKED = "tree.clear.selection.on.margin.clicked";

  public static final String TREE_SHOW_PLAIN_ICON = "tree.show.plain.icon";

  public static final String TREE_ELEMENT_DRAGGABLE = "tree.element.draggable";

  public static final String TREE_ENSURE_VISIBLE_ON_SELECTED = "tree.ensure.visible.on.selected";

  public static final String TREE_ELEMENT_TOOLTIP_DISPLAYABLE = "tree.element.tooltip.displayable";

  public static final String TREE_ENABLE_TRISTATE_CHECKBOX = "tree.enable.tristate.checkbox";

  public static final String TREE_PAINT_SELECTED_STATE_WHEN_CHECKED = "tree.paint.selected.state.when.checked";

  public static final String TREE_CHECKED_WHEN_NOT_SPECIFIED = "tree.checked.when.not.specified";

  public static final String TREE_UPDATE_SORT_ON_PROPERTY_CHANGED = "tree.update.sort.on.property.changed";

  public static final String TCHART_LAZY_PUBLISH_MODE = "tchart.lazy.publish.mode";

  public static final String TCHART_POPUP_MENU_GENERATOR = "tchart.popup.menu.generator";

  public static final String TCHART_SELECTABLE_ON_RIGHT_CLICK = "tchart.selectable.on.right.click";

  public static final String TCHART_CLEAR_SELECTION_ON_MARGIN_CLICKED = "tchart.clear.selection.on.margin.clicked";

  public static final String TCHART_ENABLE_DOUBLE_CLICK_TO_RESET = "tchart.enable.double.click.to.reset";

  public static final String TCHART_ENABLE_TOOLTIPTEXT = "tchart.enable.tooltiptext";

  public static final String TCHART_ENABLE_XTRANSLATE = "tchart.enable.xtranslate";

  public static final String TCHART_ENABLE_YTRANSLATE = "tchart.enable.ytranslate";

  public static final String TCHART_XTRANSLATE = "tchart.xtranslate";

  public static final String TCHART_YTRANSLATE = "tchart.ytranslate";

  public static final String TCHART_ENABLE_XZOOM = "tchart.enable.xzoom";

  public static final String TCHART_ENABLE_YZOOM = "tchart.enable.yzoom";

  public static final String TCHART_XZOOM = "tchart.xzoom";

  public static final String TCHART_YZOOM = "tchart.yzoom";

  public static final String TCHART_ZOOM_INCREMENT = "tchart.zoom.increment";

  public static final String TCHART_MAX_ZOOM = "tchart.max.zoom";

  public static final String TCHART_MIN_ZOOM = "tchart.min.zoom";

  public static final String TCHART_XGAP = "tchart.xgap";

  public static final String TCHART_YGAP = "tchart.ygap";

  public static final String TCHART_TEXT_GAP = "tchart.text.gap";

  public static final String TCHART_ICON_WIDTH = "tchart.icon.width";

  public static final String TCHART_ICON_HEIGHT = "tchart.icon.height";

  public static final String TCHART_UPPER_LIMIT = "tchart.upper.limit";

  public static final String TCHART_LOWER_LIMIT = "tchart.lower.limit";

  public static final String TCHART_LEGEND_FONT = "tchart.legend.font";

  public static final String TCHART_LEGEND_LAYOUT = "tchart.legend.layout";

  public static final String TCHART_LEGEND_ORIENTATION = "tchart.legend.orientation";

  public static final String TCHART_SELECTED_OFFSET = "tchart.selected.offset";

  public static final String TCHART_SELECTED_COLOR = "tchart.selected.color";

  public static final String TCHART_SELECTED_STROKE = "tchart.selected.stroke";

  public static final String TCHART_HIGHLIGHT_BACKGROUND = "tchart.highlight.background";

  public static final String TCHART_HIGHLIGHT_FOREGROUND = "tchart.highlight.foreground";

  public static final String TCHART_UNIT = "tchart.unit";

  public static final String TCHART_STROKE = "tchart.stroke";

  public static final String TCHART_FORMAT = "tchart.format";

  public static final String TCHART_VALUE_TEXT_VISIBLE = "tchart.value.text.visible";

  public static final String TCHART_VALUE_TEXT_CENTER = "tchart.value.text.center";

  public static final String TCHART_VALUE_TEXT_COLOR = "tchart.value.text.color";

  public static final String TCHART_VALUE_TEXT_FONT = "tchart.value.text.font";

  public static final String TCHART_VALUE_TEXT_POSITION = "tchart.value.text.positon";

  public static final String TCHART_ANTIALIAS = "tchart.antialias";

  public static final String TCHART_GRADIENT = "tchart.gradient";

  public static final String TCHART_GRADIENT_COLOR = "tchart.gradient.color";

  public static final String TCHART_XAXIS_VISIBLE = "tchart.xaxis.visible";

  public static final String TCHART_XAXIS_FILL_COLOR = "tchart.xaxis.fill.color";

  public static final String TCHART_XAXIS_OUTLINE_COLOR = "tchart.xaxis.outline.color";

  public static final String TCHART_XAXIS_TEXT_FONT = "tchart.xaxis.text.font";

  public static final String TCHART_XAXIS_TEXT_COLOR = "tchart.xaxis.text.color";

  public static final String TCHART_XAXIS_TEXT = "tchart.xaxis.text";

  public static final String TCHART_XAXIS_VALUE = "tchart.xaxis.value";

  public static final String TCHART_XAXIS_STROKE = "tchart.xaxis.stroke";

  public static final String TCHART_XAXIS_UNIT = "tchart.xaxis.unit";

  public static final String TCHART_XAXIS_UNIT_VISIBLE = "tchart.xaxis.unit.visible";

  public static final String TCHART_XAXIS_UNIT_COLOR = "tchart.xaxis.unit.color";

  public static final String TCHART_XAXIS_UNIT_FONT = "tchart.xaxis.unit.font";

  public static final String TCHART_XAXIS_START_POSITION = "tchart.xaxis.start.position";

  public static final String TCHART_YAXIS_UNIT = "tchart.yaxis.unit";

  public static final String TCHART_YAXIS_UNIT_VISIBLE = "tchart.yaxis.unit.visible";

  public static final String TCHART_YAXIS_UNIT_COLOR = "tchart.yaxis.unit.color";

  public static final String TCHART_YAXIS_UNIT_FONT = "tchart.yaxis.unit.font";

  public static final String TCHART_YAXIS_START_POSITION = "tchart.yaxis.start.position";

  public static final String TCHART_XSCALE_TEXT_ONTOP = "tchart.xscale.text.ontop";

  public static final String TCHART_YSCALE_MIN_VALUE = "tchart.yscale.min.value";

  public static final String TCHART_YSCALE_MAX_VALUE = "tchart.yscale.max.value";

  public static final String TCHART_XAXIS_START_VALUE = "tchart.xaxis.start.value";

  public static final String TCHART_YAXIS_VISIBLE = "tchart.yaxis.visible";

  public static final String TCHART_YAXIS_FILL_COLOR = "tchart.yaxis.fill.color";

  public static final String TCHART_YAXIS_OUTLINE_COLOR = "tchart.yaxis.outline.color";

  public static final String TCHART_YAXIS_TEXT_FONT = "tchart.yaxis.text.font";

  public static final String TCHART_YAXIS_TEXT_COLOR = "tchart.yaxis.text.color";

  public static final String TCHART_YAXIS_TEXT = "tchart.yaxis.text";

  public static final String TCHART_YAXIS_STROKE = "tchart.yaxis.stroke";

  public static final String TCHART_YAXIS_START_VALUE = "tchart.yaxis.start.value";

  public static final String TCHART_BACKGROUND_VISIBLE = "tchart.background.visible";

  public static final String TCHART_BACKGROUND_FILL_COLOR = "tchart.background.fill.color";

  public static final String TCHART_BACKGROUND_OUTLINE_COLOR = "tchart.background.outline.color";

  public static final String TCHART_BACKGROUND_STROKE = "tchart.background.stroke";

  public static final String TCHART_BACKGROUND_GRADIENT = "tchart.background.gradient";

  public static final String TCHART_BACKGROUND_GRADIENT_COLOR = "tchart.background.gradient.color";

  public static final String TCHART_BACKGROUND_GRADIENT_FACTORY = "tchart.background.gradient.factory";

  public static final String TCHART_YSCALE_LINE_STROKE = "tchart.yscale.line.stroke";

  public static final String TCHART_YSCALE_LINE_COLOR = "tchart.yscale.line.color";

  public static final String TCHART_YSCALE_PIXEL_GAP = "tchart.yscale.pixel.gap";

  public static final String TCHART_YSCALE_VALUE_GAP = "tchart.yscale.value.gap";

  public static final String TCHART_YSCALE_LINE_VISIBLE = "tchart.yscale.line.visible";

  public static final String TCHART_YSCALE_MIN_TEXT_VISIBLE = "tchart.yscale.min.text.visible";

  public static final String TCHART_YSCALE_TEXT_VISIBLE = "tchart.yscale.text.visible";

  public static final String TCHART_YSCALE_TEXT_INSIDE = "tchart.yscale.text.inside";

  public static final String TCHART_YSCALE_TEXT_FORMAT = "tchart.yscale.text.format";

  public static final String TCHART_YSCALE_TEXT_COLOR = "tchart.yscale.text.color";

  public static final String TCHART_YSCALE_TEXT_FONT = "tchart.yscale.text.font";

  public static final String TCHART_YSCALE_VALUE_GAP_AUTO_CALCULATE = "tchart.yscale.value.gap.auto.calculate";

  public static final String TCHART_SHADOW_OFFSET = "tchart.shadow.offset";

  public static final String TCHART_INFLEXION_STYLE = "tchart.inflexion.style";

  public static final String TCHART_INFLEXION_VISIBLE = "tchart.inflexion.visible";

  public static final String TCHART_XSCALE_LINE_STROKE = "tchart.xscale.line.stroke";

  public static final String TCHART_XSCALE_LINE_COLOR = "tchart.xscale.line.color";

  public static final String TCHART_XSCALE_LINE_VISIBLE = "tchart.xscale.line.visible";

  public static final String TCHART_XSCALE_TEXT_FONT = "tchart.xscale.text.font";

  public static final String TCHART_XSCALE_TEXT_COLOR = "tchart.xscale.text.color";

  public static final String TCHART_XSCALE_TEXT_VISIBLE = "tchart.xscale.text.visible";

  public static final String TCHART_XSCALE_TEXT_ORIENTATION = "tchart.xscale.text.orientation";

  public static final String TCHART_XSCALE_TEXT_FORMAT = "tchart.xscale.text.format";

  public static final String TCHART_XSCALE_VALUE_GAP = "tchart.xscale.value.gap";

  public static final String TCHART_XSCALE_PIXEL_GAP = "tchart.xscale.pixel.gap";

  public static final String TCHART_XSCALE_MIN_VALUE = "tchart.xscale.min.value";

  public static final String TCHART_XSCALE_MAX_VALUE = "tchart.xscale.max.value";

  public static final String TCHART_XSCALE_HIDE_VALUE_INDEX = "tchart.xscale.hide.value.index";

  public static final String TCHART_YSCALE_HIDE_VALUE_INDEX = "tchart.yscale.hide.value.index";

  public static final String TCHART_VALUE_TEXT_PERCENT = "tchart.value.text.percent";

  public static final String TCHART_START_ANGLE = "tchart.start.angle";

  public static final String TCHART_SHADOW_COLOR = "tchart.shadow.color";

  public static final String TCHART_PERCENT_GAP = "tchart.percent.gap";

  public static final String TCHART_THICKNESS = "tchart.thickness";

  public static final String TCHART_SEGMENT_COUNT = "tchart.segment.count";

  public static final String TCHART_SEGMENT_SECTION_PRORATE = "tchart.segment.section.prorate";

  public static final String TCHART_PERCENT_LABEL_FONT = "tchart.percent.label.font";

  public static final String TCHART_PERCENT_LABEL_COLOR = "tchart.percent.label.color";

  public static final String TCHART_PERCENT_LABEL_VISIBLE = "tchart.percent.label.visible";

  public static final String TCHART_PERCENT_LABEL_CENTER = "tchart.percent.label.center";

  public static final String TCHART_PERCENT_TYPE = "tchart.percent.type";

  public static final String TCHART_PERCENT_MARKER_POSITION = "tchart.percent.marker.position";

  public static final String TCHART_PERCENT_SPARE_GRADIENT_COLOR = "tchart.percent.spare.gradient.color";

  public static final String TCHART_PERCENT_SPARE_FILL = "tchart.percent.spare.fill";

  public static final String TCHART_BUBBLE_GRADIENT = "tchart.bubble.gradient";

  public static final String TCHART_BUBBLE_GRADIENT_FACTORY = "tchart.bubble.gradient.factory";

  public static final String TCHART_BUBBLE_GRADIENT_COLOR = "tchart.bubble.gradient.color";

  public static final String TCHART_BUBBLE_ALPHA = "tchart.bubble.alpha";

  public static final String TCHART_BUBBLE_STYLE = "tchart.bubble.style";

  public static final String TCHART_BUBBLE_AREA_SELECTABLE = "tchart.bubble.area.selectable";

  public static final String TCHART_BUBBLE_SHAPE_LINE_VISIBLE = "tchart.bubble.shape.line.visible";

  public static final String TCHART_BUBBLE_SHAPE_BUBBLE_VISIBLE = "tchart.bubble.shape.bubble.visible";

  public static final String TCHART_PIE_PERCENT_VALUE_FORMAT = "tchart.pie.percent.value.format";

  public static final String TCHART_PIE_VALUE_TEXT_POSITION_SCALE = "tchart.pie.value.text.position.scale";

  public static final String TCHART_PIE_3D = "tchart.pie.3d";

  public static final String TCHART_PERCENT_MARKER_START_POSITION = "tchart.percent.marker.start.position";

  public static final String TCHART_SPARE_COLOR = "tchart.spare.color";

  public static final String TCHART_OUTLINE_COLOR = "tchart.outline.color";

  public static final String TCHART_BAR_TYPE = "tchart.bar.type";

  public static final String TCHART_BAR_BUNDLE_SIZE = "tchart.bar.bundle.size";

  public static final String TCHART_BAR_PERCENT_TYPE_VALUE_VISIBLE = "tchart.bar.percent.type.value.visible";

  public static final String TCHART_LINE_TYPE = "tchart.line.type";

  public static final String TCHART_INTERRUPTED_WHEN_NULL_VALUE = "tchart.interrupted.when.null.value";

  public static final String TCHART_HOLLOW = "tchart.hollow";

  public static final String TCHART_HOLLOW_PERCENT = "tchart.hollow.percent";

  public static final String TCHART_DIAL_TYPE = "tchart.dial.type";

  public static final String TCHART_DIAL_ARCRANGE = "tchart.dial.arcrange";

  public static final String TCHART_DIAL_START_ANGLE = "tchart.dial.start.angle";

  public static final String TCHART_DIAL_END_ANGLE = "tchart.dial.end.angle";

  public static final String TCHART_DIAL_MAX_VALUE = "tchart.dial.max.value";

  public static final String TCHART_DIAL_MIN_VALUE = "tchart.dial.min.value";

  public static final String TCHART_DIAL_SCALE_INSIDE = "tchart.dial.scale.inside";

  public static final String TCHART_DIAL_SCALE_MAJOR_COUNT = "tchart.dial.scale.major.count";

  public static final String TCHART_DIAL_SCALE_MINOR_COUNT = "tchart.dial.scale.minor.count";

  public static final String TCHART_DIAL_SCALE_MINOR_VISIBLE = "tchart.dial.scale.minor.visible";

  public static final String TCHART_DIAL_SCALE_STROKE = "tchart.dial.scale.stroke";

  public static final String TCHART_DIAL_SCALE_TEXT_FONT = "tchart.dial.scale.text.font";

  public static final String TCHART_DIAL_SCALE_COLOR = "tchart.dial.scale.color";

  public static final String TCHART_DIAL_SCALE_TEXT_VISIBLE = "tchart.dial.scale.text.visible";

  public static final String TCHART_DIAL_SCALE_LENGTH = "tchart.dial.scale.length";

  public static final String TCHART_DIAL_SCALE_MINTEXT_VISIBLE = "tchart.dial.scale.mintext.visible";

  public static final String TCHART_DIAL_SCALE_TEXT_COLOR = "tchart.dial.scale.text.color";

  public static final String TCHART_DIAL_SCALE_STYLE = "tchart.dial.scale.style";

  public static final String TCHART_DIAL_RING_STROKE = "tchart.dial.ring.stroke";

  public static final String TCHART_DIAL_RING_COLOR = "tchart.dial.ring.color";

  public static final String TCHART_DIAL_RING_GRADIENT_COLOR = "tchart.dial.ring.gradient.color";

  public static final String TCHART_DIAL_RING_GRADIENT_FACTORY = "tchart.dial.ring.gradient.factory";

  public static final String TCHART_DIAL_RING_BORDER_COLOR = "tchart.dial.ring.border.color";

  public static final String TCHART_DIAL_RING_BORDER_VISIBLE = "tchart.dial.ring.border.visible";

  public static final String TCHART_DIAL_RING_GRADIENT = "tchart.dial.ring.gradient";

  public static final String TCHART_DIAL_RING_FILL_COLOR = "tchart.dial.ring.fill.color";

  public static final String TCHART_DIAL_BALL_GRADIENT_COLOR = "tchart.dial.ball.gradient.color";

  public static final String TCHART_DIAL_BALL_COLOR = "tchart.dial.ball.color";

  public static final String TCHART_DIAL_BALL_BORDER_COLOR = "tchart.dial.ball.border.color";

  public static final String TCHART_DIAL_BALL_SIZE = "tchart.dial.ball.size";

  public static final String TCHART_DIAL_BALL_GRADIENT = "tchart.dial.ball.gradient";

  public static final String TCHART_DIAL_BALL_GRADIENT_FACTORY = "tchart.dial.ball.gradient.factory";

  public static final String TCHART_DIAL_BALL_PERCENT_SIZE = "tchart.dial.ball.percent.size";

  public static final String TCHART_RADAR_AXIS_TEXT_FONT = "tchart.radar.axis.text.font";

  public static final String TCHART_RADAR_AXIS_TEXT_COLOR = "tchart.radar.axis.text.color";

  public static final String TCHART_RADAR_AXIS_TEXT_VISIBLE = "tchart.radar.axis.text.visible";

  public static final String TCHART_RADAR_AXIS_VISIBLE = "tchart.radar.axis.visible";

  public static final String TCHART_RADAR_AXIS_COLOR = "tchart.radar.axis.color";

  public static final String TCHART_RADAR_AXIS_STROKE = "tchart.radar.axis.stroke";

  public static final String TCHART_RADAR_AXIS_START_ANGLE = "tchart.radar.axis.start.angle";

  public static final String TCHART_RADAR_SCALE_MAX_VALUE = "tchart.radar.scale.max.value";

  public static final String TCHART_RADAR_SCALE_MIN_VALUE = "tchart.radar.scale.min.value";

  public static final String TCHART_RADAR_SCALE_MAJOR_TEXT_FONT = "tchart.radar.scale.major.text.font";

  public static final String TCHART_RADAR_SCALE_MAJOR_TEXT_VISIBLE = "tchart.radar.scale.major.text.visible";

  public static final String TCHART_RADAR_SCALE_MAJOR_TEXT_COLOR = "tchart.radar.scale.major.text.color";

  public static final String TCHART_RADAR_SCALE_MAJOR_COUNT = "tchart.radar.scale.major.count";

  public static final String TCHART_RADAR_SCALE_MIN_COUNT = "tchart.radar.scale.min.count";

  public static final String TCHART_RADAR_RING_VISIBLE = "tchart.radar.ring.visible";

  public static final String TCHART_RADAR_RING_MAJOR_COLOR = "tchart.radar.ring.major.color";

  public static final String TCHART_RADAR_RING_MAJOR_STROKE = "tchart.radar.ring.major.stroke";

  public static final String TCHART_RADAR_RING_MIN_COLOR = "tchart.radar.ring.min.color";

  public static final String TCHART_RADAR_RING_MIN_STROKE = "tchart.radar.ring.min.stroke";

  public static final String TCHART_RADAR_RING_MIN_VISIBLE = "tchart.radar.ring.min.visible";

  public static final String TCHART_RADAR_RING_STYLE = "tchart.radar.ring.style";

  public static final String TCHART_RADAR_FILL = "tchart.radar.fill";

  public static final String TCHART_RADAR_FILL_COLOR = "tchart.radar.fill.color";

  public static final String TCHART_RADAR_FILL_GRADIENT = "tchart.radar.fill.gradient";

  public static final String TCHART_RADAR_FILL_GRADIENT_COLOR = "tchart.radar.fill.gradient.color";

  public static final String TCHART_RADAR_FILL_GRADIENT_FACTORY = "tchart.radar.fill.gradient.factory";

  public static final String TCHART_RADAR_SHAPE_FILL_GRADIENT = "tchart.radar.shape.fill.gradient";

  public static final String TCHART_RADAR_SHAPE_FILL_GRADIENT_COLOR = "tchart.radar.shape.fill.gradient.color";

  public static final String TCHART_RADAR_AXIS_INFLEXION_VISIBLE = "tchart.radar.axis.inflexion.visible";

  public static final String TCHART_RADAR_AXIS_INFLEXION_STYLE = "tchart.radar.axis.inflexion.style";

  public static final String TCHART_RADAR_AXIS_TEXT_TOOLTIP_VISIBLE = "tchart.radar.axis.text.tooltip.visible";

  public static final String TCHART_RADAR_INFLEXION_VISIBLE = "tchart.radar.inflexion.visible";

  public static final String TCHART_RADAR_LINE_VISIBLE = "tchart.radar.line.visible";

  public static final String TCHART_RADAR_AREA_FILL = "tchart.radar.area.fill";

  public static final String LIST_ENABLE_RIGHT_CLICK_EVENT = "list.enable.right.click.event";

  public static final String LIST_LAZY_PUBLISH_MODE = "list.lazy.publish.mode";

  public static final String LIST_UNCHECKABLE_STYLE = "list.uncheckable.style";

  public static final String LIST_SELECTION_MODE = "list.selection.mode";

  public static final String LIST_ENSURE_VISIBLE_ON_SELECTED = "list.ensure.visible.on.selected";

  public static final String LIST_ICON_VISIBLE = "list.icon.visible";

  public static final String LIST_PAINT_SELECTED_STATE_WHEN_CHECKED = "list.paint.selected.state.when.checked";

  public static final String LIST_SELECTABLE_ON_RIGHT_CLICK = "list.selectable.on.right.click";

  public static final String LIST_CLEAR_SELECTION_ON_MARGIN_CLICKED = "list.clear.selection.on.margin.clicked";

  public static final String COMBOBOX_LAZY_PUBLISH_MODE = "combobox.lazy.publish.mode";

  public static final String COMBOBOX_ICON_VISIBLE = "combobox.icon.visible";

  public static final String COMBOBOX_POPUP_WITH_PREFERRED_WIDTH = "combobox.popup.with.preferred.width";

  public static final String SHEET_MODE = "sheet.mode";

  public static final String SHEET_EDITABLE = "sheet.editable";

  public static final String SHEET_RESTORE_CATEGORY_STATE = "sheet.restore.category.state";

  public static final String SHEET_ENABLE_CATEGORY_INTERACTION = "sheet.enable.category.interaction";

  public static final String SHEET_SORTING_ASCENDING = "sheet.sorting.ascending";

  public static final String SHEET_INDENT_OPAQUE = "sheet.indent.opaque";

  public static final String SHEET_CATEGORY_FONT_BOLD = "sheet.category.font.bold";

  public static final String SHEET_PROPERTY_DISTINCT_LEVEL = "sheet.property.distinct.level";

  public static final String SHEET_SORTING_PROPERTIES = "sheet.sorting.properties";

  public static final String SHEET_SORTING_CATEGORIES = "sheet.sorting.categories";

  public static final String SHEET_PROPERTY_SORTING_COMPARATOR = "sheet.property.sorting.comparator";

  public static final String SHEET_CATEGORY_SORTING_COMPARATOR = "sheet.category.sorting.comparator";

  public static final String SHEET_SINGLE_ROOT_CATEGORY_VISIBLE = "sheet.single.root.category.visible";

  public static final String SHEET_PROPERTY_EXTRA_INDENT = "sheet.property.extra.indent";

  public static final String SHEET_DESCRIPTION_VISIBLE = "sheet.description.visible";

  public static final String SHEET_SHOW_VALUE_IN_DESCRIPTION = "sheet.show.value.in.description";

  public static final String SHEET_FILL_INDENT = "sheet.fill.indent";

  public static final String NETWORK_CURRENTSUBNETWORK = "currentSubNetwork";

  public static final String NETWORK_FULL_SCREEN_KEYBOARD = "network.full.screen.keyboard";

  public static final String NETWORK_ZOOM_INCREMENT = "network.zoom.increment";

  public static final String NETWORK_WHEEL_ZOOM_INCREMENT = "network.wheel.zoom.increment";

  public static final String NETWORK_MAGNIFIER_ZOOM_FACTOR = "network.magnifier.zoom.factor";

  public static final String NETWORK_MAGNIFIER_SHAPE = "network.magnifier.shape";

  public static final String NETWORK_MAGNIFIER_SHAPE_MAP = "network.magnifier.shape.map";

  public static final String NETWORK_MAGNIFIER_FACTOR_MAP = "network.magnifier.factor.map";

  public static final String NETWORK_ENABLE_RIGHT_CLICK_EVENT = "network.enable.right.click.event";

  public static final String NETWORK_STRAIGHT_LINK_OFFSET = "network.straight.link.offset";

  public static final String NETWORK_STRAIGHT_LINK_GAP = "network.straight.link.gap";

  public static final String NETWORK_PARALLEL_LINK_OFFSET = "network.parallel.link.offset";

  public static final String NETWORK_PARALLEL_LINK_GAP = "network.parallel.link.gap";

  public static final String NETWORK_LINK_BUNDLE_COMPACT = "network.link.bundle.compact";

  public static final String NETWORK_LINK_BUNDLE_ALTERNATE = "network.link.bundle.alternate";

  public static final String NETWORK_ENABLE_ATTACHMENT_DEAFULT_ACTION = "network.enable.attachment.default.action";

  public static final String NETWORK_CONSIDER_ATTACHMENT_ON_LAYOUT = "network.consider.attachment.on.layout";

  public static final String NETWORK_EXPAND_GROUP_AFTER_LAYOUT = "network.expand.group.after.layout";

  public static final String NETWORK_SHOW_PLAIN_ELEMENT = "network.show.plain.element";

  public static final String NETWORK_ENABLE_ILLEGAL_LINK_VISIBLE = "network.enable.illegal.link.visible";

  public static final String NETWORK_ENABLE_DOUBLE_CLICK_TO_UP = "network.enable.double.click.to.up";

  public static final String NETWORK_ENABLE_ENTER_EMPTY_SUBNETWORK = "network.enable.enter.empty.subnetwork";

  public static final String NETWORK_ENABLE_AUTO_SCROLL = "network.enable.auto.scroll";

  public static final String NETWORK_ENABLE_MOUSE_WHEEL_TO_ZOOM = "network.enable.mouse.wheel.to.zoom";

  public static final String NETWORK_SHOW_LINK_BUNDLE_HANDLER = "network.show.link.bundle.handler";

  public static final String NETWORK_ENABLE_AUTO_ADJUST_CANVAS_SIZE = "network.enable.auto.adjust.canvas.size";

  public static final String NETWORK_LIMIT_ELEMENT_IN_POSITIVE_LOCATION = "network.limit.element.in.positive.location";

  public static final String NETWORK_SELECTABLE_ON_RIGHT_CLICK = "network.selectable.on.right.click";

  public static final String NETWORK_CLEAR_SELECTION_ON_MARGIN_CLICKED = "network.clear.selection.on.margin.clicked";

  public static final String NETWORK_APPLY_BACKGROUND_THROUGH_SUBNETWORK = "network.apply.background.through.subnetwork";

  public static final String NETWORK_ALARM_BALLOON_VISIBLE = "network.alarm.balloon.visible";

  public static final String NETWORK_ENABLE_ANIMATION = "network.enable.animation";

  public static final String NETWORK_ENABLE_BLINKING = "network.enable.blinking";

  public static final String NETWORK_ELEMENT_TRANSPARENT_AREA_SELECTABLE = "network.element.transparent.area.selectable";

  public static final String NETWORK_ENSURE_VISIBLE_ON_SELECTED = "network.ensure.visible.on.selected";

  public static final String NETWORK_KEYBOARD_ENABLE_SELECT_ALL = "network.keyboard.enable.select.all";

  public static final String NETWORK_KEYBOARD_ENABLE_COPY_PASTE = "network.keyboard.enable.copy.paste";

  public static final String NETWORK_KEYBOARD_ENABLE_UNDO_REDO = "network.keyboard.enable.undo.redo";

  public static final String NETWORK_KEYBOARD_ENABLE_DELETE = "network.keyboard.enable.delete";

  public static final String NETWORK_KEYBOARD_ENABLE_SWITCH_FULL_SCREEN = "network.keyboard.enable.switch.full.screen";

  public static final String NETWORK_KEYBOARD_ENABLE_EXIT_FULL_SCREEN = "network.keyboard.enable.exit.full.screen";

  public static final String NETWORK_ENABLE_DND = "network.enable.dnd";

  public static final String NETWORK_ANIMATE_COMPONENT_ATTACHMENT = "network.animate.component.attachment";

  public static final String NETWORK_ANIMATE_SUBNETWORK_ENTER = "network.animate.subnetwork.enter";

  public static final String NETWORK_ANIMATE_ELEMENT_MOVE = "network.animate.element.move";

  public static final String NETWORK_ANIMATE_ELEMENT_DELETE = "network.animate.element.delete";

  public static final String NETWORK_ANIMATE_ELEMENT_RESIZE = "network.animate.element.resize";

  public static final String XML_OUTPUT_WITH_ELEMENTID = "xml.output.with.elementid";

  public static final String XML_OUTPUT_WITH_LAYERS = "xml.output.with.layers";

  public static final String XML_OUTPUT_WITH_ALARM = "xml.output.with.alarm";

  public static final String XML_OUTPUT_WITH_ALARMID = "xml.output.with.alarmid";

  public static final String XML_OUTPUT_WITH_ALARMSTATE = "xml.output.with.alarmstate";

  public static final String XML_OUTPUT_WITH_DATABOXCLIENTPROPERTY = "xml.output.with.databoxclientproperty";

  public static final String XML_OUTPUT_WITH_DATABOXID = "xml.output.with.databoxid";

  public static final String XML_OUTPUT_WITH_DATABOXNAME = "xml.output.with.databoxname";

  public static final String XML_OUTPUT_WITH_DATABOXVERSION = "xml.output.with.databoxversion";

  public static final String XML_OUTPUT_WITH_DATABOXBACKGROUND = "xml.output.with.databoxbackground";

  public static final String XML_OUTPUT_WITH_USERPROPERTY = "xml.output.with.userproperty";

  public static final String XML_OUTPUT_WITH_BUSINESSOBJECT = "xml.output.with.businessobject";

  public static final String XML_OUTPUT_ELEMENTFILTER = "xml.output.elementfilter";

  public static final String XML_OUTPUT_CLIENTPROPERTYFILTER = "xml.output.clientpropertyfilter";

  public static final String XML_OUTPUT_ELEMENTDELEGATEINTERCEPTOR = "xml.output.elementdelegateinterceptor";

  public static final String DATABOX_ALARMPROPAGATOR = "alarmPropagator";

  public static final String DATABOX_ID = "id";

  public static final String DATABOX_NAME = "name";

  public static final String DATABOX_VERSION = "version";

  public static final String DATABOX_BACKGROUND = "background";

  public static final String DATABOX_TAGLINKWHENALARMSTATECHANGED = "tagLinkWhenAlarmStateChanged";

  public static final String JAR_OUTPUT_XML_NAME = "data.xml";

  public static final String JAR_OUTPUT_IMAGE_PREFIX = "JarImage_";

  public static final String CATEGORY_SYSTEM = "system";

  public static final String CATEGORY_SYSTEM_BASIC = "system.basic";

  public static final String CATEGORY_SYSTEM_BORDER = "system.border";

  public static final String CATEGORY_SYSTEM_ALARM = "system.alarm";

  public static final String CATEGORY_SYSTEM_LABEL = "system.label";

  public static final String CATEGORY_SYSTEM_MESSAGE = "system.message";

  public static final String CATEGORY_SYSTEM_ATTACHMENT = "system.attachment";

  public static final String CATEGORY_SYSTEM_CUSTOM = "system.custom";

  public static final String CATEGORY_SYSTEM_LINK = "system.link";

  public static final String CATEGORY_SYSTEM_LINK_FROM = "system.link.from";

  public static final String CATEGORY_SYSTEM_LINK_TO = "system.link.to";

  public static final String CATEGORY_SYSTEM_LINK_HANDLER = "system.link.handler";

  public static final String CATEGORY_SYSTEM_GROUP = "system.group";

  public static final String CATEGORY_SYSTEM_SHAPENODE = "system.shapenode";

  public static final String CATEGORY_SYSTEM_SUBNETWORK = "system.subnetwork";

  public static final String CATEGORY_SYSTEM_EQUIPMENT = "system.equipment";

  public static final String CATEGORY_SYSTEM_ASPECT = "system.aspect";

  public static final String CATEGORY_PREFIX = "category.";

  public static final String SEGMENT_LINECOLOR = "lineColor";

  public static final String SEGMENT_VISIBLE = "visible";

  public static final String SEGMENT_FROMPOINT = "fromPoint";

  public static final String SEGMENT_TOPOINT = "toPoint";

  public static final String SEGMENT_FROMNODE = "fromNode";

  public static final String SEGMENT_TONODE = "toNode";

  public static final String BRANCH_SEGMENT = "segment";

  public static final String BRANCH_BRANCHCOLOR = "branchColor";

  public static final String BRANCH_VISIBLE = "visible";

  public static final String ALL_CLIENTPROPERTIES = "all.clientproperties";

  public static final String ALL_USERPROPERTIES = "all.userproperties";

  public static final String PROPERTYNAME_LAYERID = "layerID";

  public static final String PROPERTYNAME_ICON = "icon";

  public static final String PROPERTYNAME_IMAGE = "image";

  public static final String PROPERTYNAME_ALARMSTATE = "alarmState";

  public static final String PROPERTYNAME_ENABLEALARMPROPAGATIONFROMCHILDREN = "enableAlarmPropagationFromChildren";

  public static final String PROPERTYNAME_CHILDREN = "children";

  public static final String PROPERTYNAME_PARENT = "parent";

  public static final String PROPERTYNAME_NAME = "name";

  public static final String PROPERTYNAME_GEOCOORDINATE = "geoCoordinate";

  public static final String PROPERTYNAME_DISPLAYNAME = "displayName";

  public static final String PROPERTYNAME_USEROBJECT = "userObject";

  public static final String PROPERTYNAME_BUSINESSOBJECT = "businessObject";

  public static final String PROPERTYNAME_TOOLTIPTEXT = "toolTipText";

  public static final String PROPERTYNAME_SELECTED = "selected";

  public static final String PROPERTYNAME_VISIBLE = "visible";

  public static final String PROPERTYNAME_LOCATION = "location";

  public static final String PROPERTYNAME_SIZE = "size";

  public static final String PROPERTYNAME_WIDTH = "width";

  public static final String PROPERTYNAME_HEIGHT = "height";

  public static final String PROPERTYNAME_EXPAND = "expand";

  public static final String PROPERTYNAME_BASESHAPE = "baseShape";

  public static final String PROPERTYNAME_TRANSFORMEDSHAPE = "transformedShape";

  public static final String PROPERTYNAME_HOST = "host";

  public static final String PROPERTYNAME_EXIST = "exist";

  public static final String PROPERTYNAME_TAG = "tag";

  public static final String PROPERTYNAME_FROM = "from";

  public static final String PROPERTYNAME_TO = "to";

  public static final String PROPERTYNAME_FROMAGENT = "fromAgent";

  public static final String PROPERTYNAME_TOAGENT = "toAgent";

  public static final String PROPERTYNAME_LINKTYPE = "linkType";

  public static final String PROPERTYNAME_GROUPTYPE = "groupType";

  public static final String PROPERTYNAME_SHAPENODETYPE = "shapeNodeType";

  public static final String PROPERTYNAME_SHAPELINKTYPE = "shapeLinkType";

  public static final String PROPERTYNAME_BTSANTENNAPOWER = "power";

  public static final String PROPERTYNAME_BEAMDIRECTION = "beamDirection";

  public static final String PROPERTYNAME_BEAMWIDTH = "beamWidth";

  public static final String PROPERTYNAME_BEAMALPHA = "beamAlpha";

  public static final String PROPERTYNAME_ANTENNA = "antenna";

  public static final String PROPERTYNAME_ANTENNATYPE = "antennaType";

  public static final String PROPERTYNAME_BTS = "BTS";

  public static final String PROPERTYNAME_SHAPELINKPOINTS = "points";

  public static final String PROPERTYNAME_SHAPENODEPOINTS = "points";

  public static final String PROPERTYNAME_GROUPMODELSHAPE = "groupModelShape";

  public static final String PROPERTYNAME_GROUPUISHAPE = "groupUIShape";

  public static final String PROPERTYNAME_POLYLINESEGMENT = "segment";

  public static final String PROPERTYNAME_ANTENNASHAPE = "antennaShape";

  public static final String PROPERTYNAME_POLYLINEBLINKINGOBJECT = "blinkingObject";

  public static final String PROPERTYNAME_EQUIPINDEX = "equipIndex";

  public static final String PROPERTYNAME_EQUIPCOUNT = "equipCount";

  public static final String PROPERTYNAME_STARTINDEX = "startIndex";

  public static final String PROPERTYNAME_SPANCOUNT = "spanCount";

  public static final String PROPERTYNAME_TSUBNETWORKBACKGROUND = "background";

  public static final String PROPERTYNAME_TSUBNETWORKDATASOURCE = "dataSource";

  public static final String PROPERTYNAME_TSUBNETWORKDATALOADED = "dataLoaded";

  public static final String PROPERTYNAME_TSUBNETWORKVIEWPOINT = "viewPoint";

  public static final String PROPERTYNAME_LINKUIPATH = "linkUIPath";

  public static final String PROPERTYNAME_SHAPEFROZEN = "shapeFrozen";

  public static final String PROPERTYNAME_ANGLE = "angle";

  public static final String PROPERTYNAME_ZOOM = "zoom";

  public static final String PROPERTYNAME_ROWCOUNT = "rowCount";

  public static final String PROPERTYNAME_COLUMNCOUNT = "columnCount";

  public static final String PROPERTYNAME_ROWINDEX = "rowIndex";

  public static final String PROPERTYNAME_COLUMNINDEX = "columnIndex";

  public static final String PROPERTYNAME_ROWSPAN = "rowSpan";

  public static final String PROPERTYNAME_COLUMNSPAN = "columnSpan";

  public static final String PROPERTYNAME_PADDING = "padding";

  public static final String PROPERTYNAME_BORDER = "border";

  public static final String PROPERTYNAME_PAINTCELL = "paintCell";

  public static final String PROPERTYNAME_COLUMNPERCENTS = "columnPercents";

  public static final String PROPERTYNAME_ROWPERCENTS = "rowPercents";

  public static final String PROPERTYNAME_ELEMENT_TREE_ICON = "element.tree.icon";

  public static final String PROPERTYNAME_DRAW_IMAGE_SHAPE = "draw.image.shape";

  public static final String PROPERTYNAME_DRAW_ICON_SHAPE = "draw.icon.shape";

  public static final String PROPERTYNAME_RENDER_ALPHA = "render.alpha";

  public static final String PROPERTYNAME_RENDER_COLOR = "render.color";

  public static final String PROPERTYNAME_STATE_OUTLINE_COLOR = "state.outline.color";

  public static final String PROPERTYNAME_STATE_OUTLINE_INSETS = "state.outline.insets";

  public static final String PROPERTYNAME_STATE_OUTLINE_WIDTH = "state.outline.width";

  public static final String PROPERTYNAME_TEXTURE_FACTORY = "texture.factory";

  public static final String PROPERTYNAME_BODY_COLOR = "body.color";

  public static final String PROPERTYNAME_BODY_RAISED = "body.raised";

  public static final String PROPERTYNAME_BODY_FILL = "body.fill";

  public static final String PROPERTYNAME_BORDER_ANTIALIAS = "border.antialias";

  public static final String PROPERTYNAME_BORDER_VISIBLE = "border.visible";

  public static final String PROPERTYNAME_BORDER_STROKE = "border.stroke";

  public static final String PROPERTYNAME_BORDER_COLOR = "border.color";

  public static final String PROPERTYNAME_BORDER_FILL = "border.fill";

  public static final String PROPERTYNAME_BORDER_FILL_COLOR = "border.fill.color";

  public static final String PROPERTYNAME_BORDER_INSETS = "border.insets";

  public static final String PROPERTYNAME_BORDER_UNDERNEATH = "border.underneath";

  public static final String PROPERTYNAME_BORDER_XORMODE = "border.xormode";

  public static final String PROPERTYNAME_BORDER_TYPE = "border.type";

  public static final String PROPERTYNAME_BORDER_SHAPE_FACTORY = "border.shape.factory";

  public static final String PROPERTYNAME_LABEL_ICON = "label.icon";

  public static final String PROPERTYNAME_LABEL_FONT = "label.font";

  public static final String PROPERTYNAME_LABEL_COLOR = "label.color";

  public static final String PROPERTYNAME_LABEL_BACKGROUND = "label.background";

  public static final String PROPERTYNAME_LABEL_VISIBLE = "label.visible";

  public static final String PROPERTYNAME_LABEL_BORDER = "label.border";

  public static final String PROPERTYNAME_LABEL_BORDER_STROKE = "label.border.stroke";

  public static final String PROPERTYNAME_LABEL_BORDER_COLOR = "label.border.color";

  public static final String PROPERTYNAME_LABEL_UNDERLINE = "label.underline";

  public static final String PROPERTYNAME_LABEL_UNDERLINE_STROKE = "label.underline.stroke";

  public static final String PROPERTYNAME_LABEL_UNDERLINE_COLOR = "label.underline.color";

  public static final String PROPERTYNAME_LABEL_POSITION = "label.position";

  public static final String PROPERTYNAME_LABEL_XOFFSET = "label.xoffset";

  public static final String PROPERTYNAME_LABEL_YOFFSET = "label.yoffset";

  public static final String PROPERTYNAME_LABEL_XGAP = "label.xgap";

  public static final String PROPERTYNAME_LABEL_YGAP = "label.ygap";

  public static final String PROPERTYNAME_LABEL_DIRECTION = "label.direction";

  public static final String PROPERTYNAME_LABEL_ORIENTATION = "label.orientation";

  public static final String PROPERTYNAME_LABEL_SELECTABLE = "label.selectable";

  public static final String PROPERTYNAME_LABEL_HIGHLIGHTABLE = "label.highlightable";

  public static final String PROPERTYNAME_LABEL_HIGHLIGHT_BACKGROUND = "label.highlight.background";

  public static final String PROPERTYNAME_LABEL_HIGHLIGHT_FOREGROUND = "label.highlight.foreground";

  public static final String PROPERTYNAME_LABEL_MAXLENGTH = "label.maxlength";

  public static final String PROPERTYNAME_MESSAGE_CONTENT = "message.content";

  public static final String PROPERTYNAME_MESSAGE_FONT = "message.font";

  public static final String PROPERTYNAME_MESSAGE_FOREGROUND = "message.foreground";

  public static final String PROPERTYNAME_MESSAGE_BACKGROUND = "message.background";

  public static final String PROPERTYNAME_MESSAGE_GRADIENT = "message.gradient";

  public static final String PROPERTYNAME_MESSAGE_GRADIENT_COLOR = "message.gradient.color";

  public static final String PROPERTYNAME_MESSAGE_GRADIENT_FACTORY = "message.gradient.factory";

  public static final String PROPERTYNAME_MESSAGE_POSITION = "message.position";

  public static final String PROPERTYNAME_MESSAGE_XOFFSET = "message.xoffset";

  public static final String PROPERTYNAME_MESSAGE_YOFFSET = "message.yoffset";

  public static final String PROPERTYNAME_MESSAGE_XGAP = "message.xgap";

  public static final String PROPERTYNAME_MESSAGE_YGAP = "message.ygap";

  public static final String PROPERTYNAME_MESSAGE_WIDTH = "message.width";

  public static final String PROPERTYNAME_MESSAGE_HEIGHT = "message.height";

  public static final String PROPERTYNAME_MESSAGE_COMPONENT = "message.component";

  public static final String PROPERTYNAME_MESSAGE_STYLE = "message.style";

  public static final String PROPERTYNAME_MESSAGE_DIRECTION = "message.direction";

  public static final String PROPERTYNAME_MESSAGE_OPAQUE = "message.opaque";

  public static final String PROPERTYNAME_MESSAGE_TAIL = "message.tail";

  public static final String PROPERTYNAME_MESSAGE_ARC = "message.arc";

  public static final String PROPERTYNAME_MESSAGE_MINIMIZED_ICON = "message.minimized.icon";

  public static final String PROPERTYNAME_MESSAGE_SHADOW_VISIBLE = "message.shadow.visible";

  public static final String PROPERTYNAME_MESSAGE_SHADOW_COLOR = "message.shadow.color";

  public static final String PROPERTYNAME_MESSAGE_BORDER_VISIBLE = "message.border.visible";

  public static final String PROPERTYNAME_MESSAGE_BORDER_COLOR = "message.border.color";

  public static final String PROPERTYNAME_MESSAGE_BORDER_STROKE = "message.border.stroke";

  public static final String PROPERTYNAME_MESSAGE_CLOSABLE = "message.closable";

  public static final String PROPERTYNAME_MESSAGE_SHRINKABLE = "message.shrinkable";

  public static final String PROPERTYNAME_MESSAGE_MINIMIZABLE = "message.minimizable";

  public static final String PROPERTYNAME_MESSAGE_SHRINKED = "message.shrinked";

  public static final String PROPERTYNAME_MESSAGE_MINIMIZED = "message.minimized";

  public static final String PROPERTYNAME_MESSAGE_AUTO_ADJUST_DIRECTION = "message.auto.adjust.direction";

  public static final String PROPERTYNAME_MESSAGE_SHOWN_ON_TOP = "message.shown.on.top";

  public static final String PROPERTYNAME_MESSAGE_CLOSE_URL = "message.close.url";

  public static final String PROPERTYNAME_MESSAGE_MINIMIZE_URL = "message.minimize.url";

  public static final String PROPERTYNAME_MESSAGE_INFO_URL = "message.info.url";

  public static final String PROPERTYNAME_ATTACHMENT_POSITION = "attachment.position";

  public static final String PROPERTYNAME_ATTACHMENT_ORIENTATION = "attachment.orientation";

  public static final String PROPERTYNAME_ATTACHMENT_XOFFSET = "attachment.xoffset";

  public static final String PROPERTYNAME_ATTACHMENT_YOFFSET = "attachment.yoffset";

  public static final String PROPERTYNAME_ATTACHMENT_XGAP = "attachment.xgap";

  public static final String PROPERTYNAME_ATTACHMENT_YGAP = "attachment.ygap";

  public static final String PROPERTYNAME_BLINK_BODY_SPEED = "blink.body.speed";

  public static final String PROPERTYNAME_BLINK_ICONATTACHMENT_SPEED = "blink.iconattachment.speed";

  public static final String PROPERTYNAME_BLINK_ALARMATTACHMENT_SPEED = "blink.alarmattachment.speed";

  public static final String PROPERTYNAME_ALARM_BALLOON_ALPHA = "alarm.balloon.alpha";

  public static final String PROPERTYNAME_ALARM_BALLOON_POSITION = "alarm.balloon.position";

  public static final String PROPERTYNAME_ALARM_BALLOON_DIRECTION = "alarm.balloon.direction";

  public static final String PROPERTYNAME_ALARM_BALLOON_XOFFSET = "alarm.balloon.xoffset";

  public static final String PROPERTYNAME_ALARM_BALLOON_YOFFSET = "alarm.balloon.yoffset";

  public static final String PROPERTYNAME_ALARM_BALLOON_VISIBLE = "alarm.balloon.visible";

  public static final String PROPERTYNAME_ALARM_BALLOON_TEXT_FONT = "alarm.balloon.text.font";

  public static final String PROPERTYNAME_ALARM_BALLOON_TEXT_COLOR = "alarm.balloon.text.color";

  public static final String PROPERTYNAME_ALARM_BALLOON_TEXT_BLINKABLE = "alarm.balloon.text.blinkable";

  public static final String PROPERTYNAME_ALARM_BALLOON_OUTLINE_COLOR = "alarm.balloon.outline.color";

  public static final String PROPERTYNAME_ALARM_BALLOON_SHADOW_COLOR = "alarm.balloon.shadow.color";

  public static final String PROPERTYNAME_ALARM_BALLOON_SHADOW_OFFSET = "alarm.balloon.shadow.offset";

  public static final String PROPERTYNAME_ALARM_BALLOON_SHOWN_ON_TOP = "alarm.balloon.shown.on.top";

  public static final String PROPERTYNAME_POLY_OUTLINE_WIDTH = "poly.outline.width";

  public static final String PROPERTYNAME_POLY_OUTLINE_COLOR = "poly.outline.color";

  public static final String PROPERTYNAME_POLY_FILL = "poly.fill";

  public static final String PROPERTYNAME_POLY_3D = "poly.3d";

  public static final String PROPERTYNAME_LINK_PROPORTION = "link.proportion";

  public static final String PROPERTYNAME_LINK_EXTEND = "link.extend";

  public static final String PROPERTYNAME_LINK_STYLE = "link.style";

  public static final String PROPERTYNAME_LINK_HOLLOW = "link.hollow";

  public static final String PROPERTYNAME_LINK_COLOR = "link.color";

  public static final String PROPERTYNAME_LINK_OUTLINE_COLOR = "link.outline.color";

  public static final String PROPERTYNAME_LINK_OUTLINE_WIDTH = "link.outline.width";

  public static final String PROPERTYNAME_LINK_WIDTH = "link.width";

  public static final String PROPERTYNAME_LINK_FLOWING_WIDTH = "link.flowing.width";

  public static final String PROPERTYNAME_LINK_FROMARROW = "link.fromArrow";

  public static final String PROPERTYNAME_LINK_TOARROW = "link.toArrow";

  public static final String PROPERTYNAME_LINK_FLOWING = "link.flowing";

  public static final String PROPERTYNAME_LINK_FLOWING_SPEED = "link.flowing.speed";

  public static final String PROPERTYNAME_LINK_FLOWING_CONVERSE = "link.flowing.converse";

  public static final String PROPERTYNAME_LINK_BLINKING = "link.blinking";

  public static final String PROPERTYNAME_LINK_BLINKING_COLOR = "link.blinking.color";

  public static final String PROPERTYNAME_LINK_3D = "link.3d";

  public static final String PROPERTYNAME_LINK_FLOWING_COLOR = "link.flowing.color";

  public static final String PROPERTYNAME_LINK_BUNDLE_EXPAND = "link.bundle.expand";

  public static final String PROPERTYNAME_LINK_BUNDLE_INDEX = "link.bundle.index";

  public static final String PROPERTYNAME_LINK_BUNDLE_SIZE = "link.bundle.size";

  public static final String PROPERTYNAME_LINK_LABEL_ROTATABLE = "link.label.rotatable";

  public static final String PROPERTYNAME_LINK_ANTIALIAS = "link.antialias";

  public static final String PROPERTYNAME_LINK_TO_POSITION = "link.to.position";

  public static final String PROPERTYNAME_LINK_TO_XOFFSET = "link.to.xoffset";

  public static final String PROPERTYNAME_LINK_TO_YOFFSET = "link.to.yoffset";

  public static final String PROPERTYNAME_LINK_FROM_POSITION = "link.from.position";

  public static final String PROPERTYNAME_LINK_FROM_XOFFSET = "link.from.xoffset";

  public static final String PROPERTYNAME_LINK_FROM_YOFFSET = "link.from.yoffset";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_CENTER = "link.from.arrow.center";

  public static final String PROPERTYNAME_LINK_TO_ARROW_CENTER = "link.to.arrow.center";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_STYLE = "link.from.arrow.style";

  public static final String PROPERTYNAME_LINK_TO_ARROW_STYLE = "link.to.arrow.style";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_COLOR = "link.from.arrow.color";

  public static final String PROPERTYNAME_LINK_TO_ARROW_COLOR = "link.to.arrow.color";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_OUTLINE = "link.from.arrow.outline";

  public static final String PROPERTYNAME_LINK_TO_ARROW_OUTLINE = "link.to.arrow.outline";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_OUTLINE_COLOR = "link.from.arrow.outline.color";

  public static final String PROPERTYNAME_LINK_TO_ARROW_OUTLINE_COLOR = "link.to.arrow.outline.color";

  public static final String PROPERTYNAME_LINK_TO_ARROW_XOFFSET = "link.to.arrow.xoffset";

  public static final String PROPERTYNAME_LINK_TO_ARROW_YOFFSET = "link.to.arrow.yoffset";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_XOFFSET = "link.from.arrow.xoffset";

  public static final String PROPERTYNAME_LINK_FROM_ARROW_YOFFSET = "link.from.arrow.yoffset";

  public static final String PROPERTYNAME_LINK_HANDLER_POSITION = "link.handler.position";

  public static final String PROPERTYNAME_LINK_HANDLER_XOFFSET = "link.handler.xoffset";

  public static final String PROPERTYNAME_LINK_HANDLER_YOFFSET = "link.handler.yoffset";

  public static final String PROPERTYNAME_LINK_HANDLER_VISIBLE = "link.handler.visible";

  public static final String PROPERTYNAME_LINK_HANDLER_ICON = "link.handler.icon";

  public static final String PROPERTYNAME_LINK_HANDLER_FONT = "link.handler.font";

  public static final String PROPERTYNAME_LINK_HANDLER_FOREGROUND = "link.handler.foreground";

  public static final String PROPERTYNAME_LINK_HANDLER_BACKGROUND = "link.handler.background";

  public static final String PROPERTYNAME_LINK_ORTHOGONAL_DIRECTION = "link.orthogonal.direction";

  public static final String PROPERTYNAME_CARD_BOLT_TOP = "card.bolt.top";

  public static final String PROPERTYNAME_CARD_BOLT_BOTTOM = "card.bolt.bottom";

  public static final String PROPERTYNAME_CARD_BOLT_LEFT = "card.bolt.left";

  public static final String PROPERTYNAME_CARD_BOLT_RIGHT = "card.bolt.right";

  public static final String PROPERTYNAME_CARD_EXTEND_PIXEL = "card.extend.pixel";

  public static final String PROPERTYNAME_CARD_EXTEND_PERCENT = "card.extend.percent";

  public static final String PROPERTYNAME_GROUP_OUTLINE = "group.outline";

  public static final String PROPERTYNAME_GROUP_OUTLINE_STROKE = "group.outline.stroke";

  public static final String PROPERTYNAME_GROUP_FILL = "group.fill";

  public static final String PROPERTYNAME_GROUP_OPAQUE = "group.opaque";

  public static final String PROPERTYNAME_GROUP_OUTLINE_COLOR = "group.outline.color";

  public static final String PROPERTYNAME_GROUP_FILL_COLOR = "group.fill.color";

  public static final String PROPERTYNAME_GROUP_ANGLE = "group.angle";

  public static final String PROPERTYNAME_GROUP_3D = "group.3d";

  public static final String PROPERTYNAME_GROUP_ANTIALIAS = "group.antialias";

  public static final String PROPERTYNAME_GROUP_DEEP = "group.deep";

  public static final String PROPERTYNAME_GROUP_INSETS = "group.insets";

  public static final String PROPERTYNAME_GROUP_CHILDREN_OUTCROP = "group.children.outcrop";

  public static final String PROPERTYNAME_GROUP_DOUBLE_CLICK_ENABLE = "group.double.click.enable";

  public static final String PROPERTYNAME_GROUP_HANDLER_EXPAND_ICON = "group.handler.expand.icon";

  public static final String PROPERTYNAME_GROUP_HANDLER_CLOSE_ICON = "group.handler.close.icon";

  public static final String PROPERTYNAME_GROUP_HANDLER_EMPTY_ICON = "group.handler.empty.icon";

  public static final String PROPERTYNAME_GROUP_HANDLER_VISIBLE = "group.handler.visible";

  public static final String PROPERTYNAME_GROUP_HANDLER_POSITION = "group.handler.position";

  public static final String PROPERTYNAME_GROUP_HANDLER_XOFFSET = "group.handler.xoffset";

  public static final String PROPERTYNAME_GROUP_HANDLER_YOFFSET = "group.handler.yoffset";

  public static final String PROPERTYNAME_GROUP_GRADIENT = "group.gradient";

  public static final String PROPERTYNAME_GROUP_GRADIENT_COLOR = "group.gradient.color";

  public static final String PROPERTYNAME_GROUP_GRADIENT_FACTORY = "group.gradient.factory";

  public static final String PROPERTYNAME_GROUP_CHAMFER_EDGE = "group.chamfer.edge";

  public static final String PROPERTYNAME_EQUIP_DIRECTION = "equip.direction";

  public static final String PROPERTYNAME_SHELF_BORDER = "shelf.border";

  public static final String PROPERTYNAME_SHELF_INNER_BORDER = "shelf.inner.border";

  public static final String PROPERTYNAME_SLOT_BORDER = "slot.border";

  public static final String PROPERTYNAME_SLOT_INNER_BORDER = "slot.inner.border";

  public static final String PROPERTYNAME_SHAPENODE_SHOW_DASH_LINE = "shapenode.show.dash.line";

  public static final String PROPERTYNAME_SHAPENODE_JOINT_POINT = "shapenode.joint.point";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW = "shapenode.from.arrow";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW = "shapenode.to.arrow";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_CENTER = "shapenode.from.arrow.center";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_CENTER = "shapenode.to.arrow.center";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_STYLE = "shapenode.from.arrow.style";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_STYLE = "shapenode.to.arrow.style";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_COLOR = "shapenode.from.arrow.color";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_COLOR = "shapenode.to.arrow.color";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_OUTLINE = "shapenode.from.arrow.outline";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_OUTLINE = "shapenode.to.arrow.outline";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_OUTLINE_COLOR = "shapenode.from.arrow.outline.color";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_OUTLINE_COLOR = "shapenode.to.arrow.outline.color";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_XOFFSET = "shapenode.to.arrow.xoffset";

  public static final String PROPERTYNAME_SHAPENODE_TO_ARROW_YOFFSET = "shapenode.to.arrow.yoffset";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_XOFFSET = "shapenode.from.arrow.xoffset";

  public static final String PROPERTYNAME_SHAPENODE_FROM_ARROW_YOFFSET = "shapenode.from.arrow.yoffset";

  public static final String PROPERTYNAME_BTSANTENNA_ARROW_SHOW = "btsantenna.arrow.show";

  public static final String PROPERTYNAME_BTSANTENNA_ARROW_COLOR = "btsantenna.arrow.color";

  public static final String PROPERTYNAME_BTSANTENNA_OUTLINE_SHOW = "btsantenna.outline.show";

  public static final String PROPERTYNAME_BTSANTENNA_OUTLINE_COLOR = "btsantenna.outline.color";

  public static final String PROPERTYNAME_BTSANTENNA_OUTLINE_STROKE = "btsantenna.outline.stroke";

  public static final String PROPERTYNAME_CUSTOM_DRAW = "custom.draw";

  public static final String PROPERTYNAME_CUSTOM_DRAW_SHAPE_FACTORY = "custom.draw.shape.factory";

  public static final String PROPERTYNAME_CUSTOM_DRAW_DEFAULT_BORDER = "custom.draw.default.border";

  public static final String PROPERTYNAME_CUSTOM_DRAW_ANTIALIAS = "custom.draw.antialias";

  public static final String PROPERTYNAME_CUSTOM_DRAW_FILL = "custom.draw.fill";

  public static final String PROPERTYNAME_CUSTOM_DRAW_FILL_3D = "custom.draw.fill.3d";

  public static final String PROPERTYNAME_CUSTOM_DRAW_FILL_COLOR = "custom.draw.fill.color";

  public static final String PROPERTYNAME_CUSTOM_DRAW_OUTLINE = "custom.draw.outline";

  public static final String PROPERTYNAME_CUSTOM_DRAW_OUTLINE_3D = "custom.draw.outline.3d";

  public static final String PROPERTYNAME_CUSTOM_DRAW_OUTLINE_COLOR = "custom.draw.outline.color";

  public static final String PROPERTYNAME_CUSTOM_DRAW_OUTLINE_STROKE = "custom.draw.outline.stroke";

  public static final String PROPERTYNAME_CUSTOM_DRAW_GRADIENT = "custom.draw.gradient";

  public static final String PROPERTYNAME_CUSTOM_DRAW_GRADIENT_FACTORY = "custom.draw.gradient.factory";

  public static final String PROPERTYNAME_CUSTOM_DRAW_GRADIENT_COLOR = "custom.draw.gradient.color";

  public static final String PROPERTYNAME_CHART_COLOR = "chart.color";

  public static final String PROPERTYNAME_CHART_VALUE = "chart.value";

  public static final String PROPERTYNAME_CHART_FORMAT = "chart.format";

  public static final String PROPERTYNAME_CHART_VALUES = "chart.values";

  public static final String PROPERTYNAME_CHART_STROKE = "chart.stroke";

  public static final String PROPERTYNAME_CHART_MIN = "chart.min";

  public static final String PROPERTYNAME_CHART_MAX = "chart.max";

  public static final String PROPERTYNAME_CHART_INFLEXION_STYLE = "chart.inflexion.style";

  public static final String PROPERTYNAME_CHART_PERCENT_STYLE = "chart.percent.style";

  public static final String PROPERTYNAME_CHART_MARKERS = "chart.markers";

  public static final String PROPERTYNAME_CHART_DIAL_HAND_LENGTH = "chart.dial.hand.length";

  public static final String PROPERTYNAME_CHART_DIAL_HAND_STYLE = "chart.dial.hand.style";

  public static final String PROPERTYNAME_CHART_PERCENT_SPARE_FILL = "chart.percent.spare.fill";

  public static final String PROPERTYNAME_CHART_PERCENT_SPARE_COLOR = "chart.percent.spare.color";

  public static final String PROPERTYNAME_CHART_PERCENT_SPARE_COVER_COLOR = "chart.percent.spare.cover.color";

  public static final String PROPERTYNAME_CHART_PERCENT_MARKER_POSITION = "chart.percent.marker.position";

  public static final String PROPERTYNAME_CHART_BUBBLE_STYLE = "chart.bubble.style";

  public static final String PROPERTYNAME_CHART_VALUE_TEXT_POSITION = "chart.value.text.position";

  public static final String PROPERTYNAME_CHART_BUBBLE_SHAPE_LINE_VISIBLE = "chart.bubble.shape.line.visible";

  public static final String PROPERTYNAME_CHART_BUBBLE_SHAPE_BUBBLE_VISIBLE = "chart.bubble.shape.bubble.visible";

  static {
    DEFAULT_INT_FORMATER.setMaximumFractionDigits(0);
    DEFAULT_DOUBLE_FORMATER = NumberFormat.getInstance();
    DEFAULT_DOUBLE_FORMATER.setMaximumFractionDigits(2);
    EMPTY_LIST = new ArrayList() {
      public int size() {
        return 0;
      }
    };
    BASIC_TRANSFORM = new AffineTransform();
    THINNEST_STROKE = new BasicStroke(0.0F);
    BASIC_STROKE = new BasicStroke(1.0F);
    COLOR_GRAY = new Color(50, 50, 50, 30);
    COLOR_IVORY = Color.getHSBColor(40.0F, 240.0F, 226.0F);
    COLOR_SHADOW = new Color(0, 0, 0, 125);
    COLOR_DRAKERCYAN = Color.CYAN.darker();
    COLOR_DARK = new Color(91, 91, 91);
    DND_TARGET_COLOR = Color.BLUE;
    DASHED_STROKE = new BasicStroke(1.0F, 0, 0, 10.0F, new float[] { 5.0F }, 0.0F);
    DOUBLE_WIDTH_STROKE = new BasicStroke(2.0F, 1, 1);
  }
}
