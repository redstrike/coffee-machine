object PlayingField {
    object Size {
        var width: Int = 0
            set(value) {
                field = if (value < 0) 0 else value
            }
        var height: Int = 0
            set(value) {
                field = if (value < 0) 0 else value
            }

        fun changeSize(width: Int, height: Int) {
            this.width = width
            this.height = height
        }
    }
}