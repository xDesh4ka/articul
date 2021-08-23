
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.*
import javax.swing.*
import kotlin.coroutines.*

class ArticulInterface {
    @OptIn(DelicateCoroutinesApi::class)
    fun start() {
        val frame = JFrame()
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.contentPane.layout = BorderLayout(5, 5)
        val topPanel = JPanel()

        topPanel.layout = FlowLayout()
        topPanel.add(JLabel("Articul"))

        val text = JTextField(30)
        topPanel.add(text)

        val search = JButton("Search")
        topPanel.add(search)

        val list = JList<String>()
        list.layoutOrientation = JList.VERTICAL

        val bottom = ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED)
        bottom.add(list)

        frame.add(bottom, BorderLayout.SOUTH)
        search.addActionListener {
            val articul = text.text?.let { Articul(text.text) }
            val model = DefaultListModel<String>()
            val art = articul?.disassembleStringForInterface()
            art?.forEach { model.addElement(it) }

            SwingUtilities.invokeLater()
            {
                    list.model = model
            }
        }

        frame.contentPane.add(topPanel)

        frame.pack()
        frame.isVisible = true
    }
}
