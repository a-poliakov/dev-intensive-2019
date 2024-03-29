package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Сущность "Текстовое сообщение" чата
 */
class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    val text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    /**
     * Возвращает строку содержащюю информацию о id сообщения, имени получателя/отправителя, виде сообщения ("получил/отправил") и типе сообщения ("сообщение"/"изображение")
     */
    override fun formatMessage(): String =
        "${from?.firstName} ${if (isIncoming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
}