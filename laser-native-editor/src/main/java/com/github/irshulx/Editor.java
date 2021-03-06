    /*
     * Copyright (C) 2016 Muhammed Irshad
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *      http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
    package com.github.irshulx;
    import android.content.Context;
    import android.graphics.Bitmap;
    import android.util.AttributeSet;
    import com.github.irshulx.models.EditorTextStyle;
    import com.github.irshulx.models.EditorContent;
    import com.github.irshulx.models.RenderType;

    import java.util.Map;

    public class Editor extends EditorCore {
        public Editor(Context context, AttributeSet attrs) {
            super(context, attrs);
            super.setEditorListener(null);
            //  initialize(context,parentView,renderType,_PlaceHolderText);
        }
        public void setEditorListener(EditorListener _listener){
            super.setEditorListener(_listener);
        }
        public EditorContent getContent(){
            return super.getContent();
        }
        public String getContentAsSerialized(){
            return super.getContentAsSerialized();
        }
        public String getContentAsSerialized(EditorContent state){
            return super.getContentAsSerialized(state);
        }
        public EditorContent getContentDeserialized(String EditorContentSerialized) {
            return super.getContentDeserialized(EditorContentSerialized);
        }
        public String getContentAsHTML(){
            return getHtmlExtensions().getContentAsHTML();
        }
        public String getContentAsHTML(EditorContent content){
            return getHtmlExtensions().getContentAsHTML(content);
        }
        public String getContentAsHTML(String editorContentAsSerialized){
            return getHtmlExtensions().getContentAsHTML(editorContentAsSerialized);
        }
        public void Render(EditorContent _state) {
            super.RenderEditor(_state);
        }
        public void Render(String HtmlString){
            RenderEditorFromHtml(HtmlString);
        }
        public void Render(){
            if (getRenderType() == RenderType.Editor) {
                getInputExtensions().insertEditText(0, this.PlaceHolder, null);
            }
        }
        private void RestoreState(){
            EditorContent state= getStateFromString(null);
            Render(state);
        }
        public void clearAllContents(){
             super.clearAllContents();
            if (getRenderType() == RenderType.Editor) {
                getInputExtensions().insertEditText(0, this.PlaceHolder, null);
            }
        }
        //region Miscellanious getters and setters

        /*
         *
         * Input extension
         *
         */
        public int getH1TextSize(){
            return getInputExtensions().getH1TextSize();
        }
        public void setH1TextSize(int size){
            getInputExtensions().setH1TextSize(size);
        }
        public int getH2TextSize(){
            return getInputExtensions().getH2TextSize();
        }
        public void setH2TextSize(int size){
            getInputExtensions().setH2TextSize(size);
        }
        public int getH3TextSize(){
            return getInputExtensions().getH3TextSize();
        }
        public void setH3TextSize(int size){
            getInputExtensions().setH3TextSize(size);
        }

        /**
         * Set the fontface for the editor
         *
         * @deprecated use {@link #setContentTypeface(Map)} and {@link #setHeadingTypeface(Map)} (Map)} ()} instead.
         */
        @Deprecated
        public void setFontFace(int StringResource) {
            getInputExtensions().setFontFace(StringResource);
        }


        public void UpdateTextStyle(EditorTextStyle style){
            getInputExtensions().UpdateTextStyle(style, null);
        }

        public void insertLink() {
            getInputExtensions().insertLink();
        }

        public void insertLink(String link){
            getInputExtensions().insertLink(link);
        }



        /**
         * setup the fontfaces for editor content
         * For eg:
         *Map<Integer, String> typefaceMap = new HashMap<>();
         typefaceMap.put(Typeface.NORMAL,"fonts/GreycliffCF-Medium.ttf");
         typefaceMap.put(Typeface.BOLD,"fonts/GreycliffCF-Bold.ttf");
         typefaceMap.put(Typeface.ITALIC,"fonts/GreycliffCF-Medium.ttf");
         typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/GreycliffCF-Medium.ttf");
         * @param map
         */

        public void setContentTypeface(Map<Integer,String> map){
            getInputExtensions().setContentTypeface(map);
        }

        public Map<Integer, String> getContentTypeface(){
            return getInputExtensions().getContentTypeface();
        }

        /**
         * setup the fontfaces for editor heding tags (h1,h2,h3)
         * for Eg:
         *Map<Integer, String> typefaceMap = new HashMap<>();
         typefaceMap.put(Typeface.NORMAL,"fonts/GreycliffCF-Medium.ttf");
         typefaceMap.put(Typeface.BOLD,"fonts/GreycliffCF-Bold.ttf");
         typefaceMap.put(Typeface.ITALIC,"fonts/GreycliffCF-Medium.ttf");
         typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/GreycliffCF-Medium.ttf");
         * @param map
         */
        public void setHeadingTypeface(Map<Integer, String> map){
            getInputExtensions().setHeadingTypeface(map);
        }
        public Map<Integer,String>getHeadingTypeface(){
            return getInputExtensions().getHeadingTypeface();
        }


        /*
         *
         * Divider extension
         *
         */

        public void setDividerLayout(int layout){
            this.getDividerExtensions().setDividerLayout(layout);
        }
        public void InsertDivider() {
            getDividerExtensions().InsertDivider();
        }

        /*
         *
         * Image Extension
         *
         */

        public void setEditorImageLayout(int layout){
            this.getImageExtensions().setEditorImageLayout(layout);
        }
        public void OpenImagePicker() {
            getImageExtensions().OpenImageGallery();
        }
        public void InsertImage(Bitmap bitmap){
            getImageExtensions().InsertImage(bitmap, -1);
        }

        public void onImageUploadComplete(String url, String imageId){
            getImageExtensions().onPostUpload(url, imageId);
        }
        public void onImageUploadFailed(String imageId){
            getImageExtensions().onPostUpload(null, imageId);
        }


        /*
         *
         *List Item extension
         *
         */
        public void setListItemLayout(int layout){
            this.getListItemExtensions().setListItemTemplate(layout);
        }
        public void InsertList(boolean isOrdered){
            this.getListItemExtensions().Insertlist(isOrdered);
        }


        /*
         *
         * Map Extension
         *
         */

        public void setMapViewLayout(int layout){
            this.getMapExtensions().setMapViewTemplate(layout);
        }

        public void InsertMap(){
            getMapExtensions().loadMapActivity();
        }
        public void InsertMap(String Cords){
            getMapExtensions().insertMap(Cords, null, true);
        }


        /**
         * add the express setup for the editor with toolbar
         *
         * @deprecated
         */
        @Deprecated
        public void ExpressSetup(){
         }
        //endregion


    }